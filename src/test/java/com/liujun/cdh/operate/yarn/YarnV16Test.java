package com.liujun.cdh.operate.yarn;

import com.cloudera.api.ClouderaManagerClientBuilder;
import com.cloudera.api.DataView;
import com.cloudera.api.model.*;
import com.cloudera.api.v10.HostsResourceV10;
import com.cloudera.api.v16.RootResourceV16;
import com.cloudera.api.v16.ServicesResourceV16;
import com.cloudera.api.v17.RootResourceV17;
import com.cloudera.api.v17.ServicesResourceV17;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liujun.cdh.operate.yarn.dto.DynmicResPoolCfgBusi;
import com.liujun.cdh.operate.yarn.dto.DynmicResPoolQueueRoot;
import com.liujun.cdh.operate.yarn.dto.Resource;
import com.liujun.cdh.operate.yarn.dto.SchedulableProperties;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/07
 */
public class YarnV16Test {

  private Logger LOG = LoggerFactory.getLogger(YarnV16Test.class);

  private static RootResourceV16 APIROOT;

  private static final Gson GSON = new GsonBuilder().serializeNulls().create();

  @BeforeClass
  public static void getBase() {
    APIROOT =
        new ClouderaManagerClientBuilder()
            .withHost("192.168.1.231")
            .withPort(7180)
            .withUsernamePassword("admin", "admin")
            .build()
            .getRootV16();
  }

  /** 获取集群中所有的机器 */
  @Test
  public void testYarnHostsResource() {

    HostsResourceV10 host = APIROOT.getHostsResource();

    ApiHostList list = host.readHosts(DataView.SUMMARY);

    for (ApiHost cluster : list) {
      System.out.println(cluster);
    }
  }

  @Test
  public void testgetConfig() {
    ApiConfigList config = APIROOT.getClouderaManagerResource().getConfig(DataView.SUMMARY);

    for (ApiConfig cfg : config) {
      System.out.println(cfg);
      System.out.println("---------------------------------");
    }
  }

  @Test
  public void testreadServices() {

    ServicesResourceV16 serrsCfg = APIROOT.getClustersResource().getServicesResource("cluster");
    ApiServiceList serviceList = serrsCfg.readServices(DataView.FULL);

    for (ApiService servcfg : serviceList) {
      System.out.println(servcfg);
      System.out.println("");
    }
  }

  /** 获取集群的名称 */
  @Test
  public void testGetClusterName() {
    ApiClusterList clusterList = APIROOT.getClustersResource().readClusters(DataView.SUMMARY);

    for (ApiCluster clusterItem : clusterList) {
      System.out.println(clusterItem);
    }

    String name = clusterList.getClusters().get(0).getName();

    Assert.assertEquals("cluster", name);
  }

  @Test
  public void testResourcePool() {

    ServicesResourceV16 resourceV16 = APIROOT.getClustersResource().getServicesResource("cluster");

    // ApiServiceList service = resourceV16.readServices(DataView.SUMMARY);

    //    for (ApiService serfCfg : service) {
    //
    //      System.out.println(serfCfg);
    //      System.out.println("-----");
    //    }

    ApiServiceConfig cfg = resourceV16.readServiceConfig("yarn", DataView.FULL);

    for (ApiConfig cfgVs : cfg.getConfigs()) {

      if (cfgVs.getName().equals("yarn_fs_scheduled_allocations")) {
        System.out.println("*******************************************");
        System.out.println(cfgVs);

        System.out.println("*******************************************");
      }
    }

    System.out.println("----------------------------------------");

    //    ApiServiceConfig serviceCfg =
    //        APIROOT
    //            .getClustersResource()
    //            .getServicesResource("cluster")
    //            .readServiceConfig("yarn", DataView.FULL);
    //
    //    for (ApiConfig cfg : serviceCfg.getConfigs()) {
    //      System.out.println(cfg);
    //    }
  }

  @Test
  public void parse() {
    RootResourceV16 resourceV16 =
        YarnApiV16.getRootResource("192.168.1.231", 7180, "admin", "admin");
    // 获取集群名称
    String clusterName = YarnApiV16.INSTANCE.getClusterName(resourceV16);

    ApiConfig dynmicSfvCfg = YarnApiV16.INSTANCE.getDynmicServiceCfg(resourceV16, clusterName);

    DynmicResPoolCfgBusi objValue =
        GSON.fromJson(dynmicSfvCfg.getValue(), DynmicResPoolCfgBusi.class);
    String outValue = GSON.toJson(objValue);
    System.out.println("原始 值");
    System.out.println(dynmicSfvCfg.getValue());
    System.out.println("获取后的值:");
    System.out.println(outValue);

    Assert.assertEquals(dynmicSfvCfg.getValue(), outValue);

    DynmicResPoolCfgBusi deValue =
        GSON.fromJson(dynmicSfvCfg.getDefaultValue(), DynmicResPoolCfgBusi.class);
    String outDefValue = GSON.toJson(deValue);
    Assert.assertEquals(dynmicSfvCfg.getDefaultValue(), outDefValue);

    List<DynmicResPoolQueueRoot> polls = objValue.getQueues();

    // 设置父资源池
    DynmicResPoolQueueRoot newPoolRes = new DynmicResPoolQueueRoot();
    newPoolRes.setAclAdministerApps("*");
    newPoolRes.setAclSubmitApps("*");
    newPoolRes.setName("liujungroup1");
    newPoolRes.setType("parent");
    newPoolRes.setSchedulingPolicy("drf");

    // 设置资源池路径
    SchedulableProperties schedulePro = new SchedulableProperties();

    schedulePro.setScheduleName("default");
    schedulePro.setWeight(1.0f);
    schedulePro.setMaxResources(getResource(2, 2048));
    schedulePro.setMinResources(getResource(2, 2048));
    schedulePro.setMaxChildResources(getResource(2, 2048));

    newPoolRes.getSchedulablePropertiesList().add(schedulePro);

    // 设置子资源池
    DynmicResPoolQueueRoot querChild = new DynmicResPoolQueueRoot();

    querChild.setAclAdministerApps("*");
    querChild.setAclSubmitApps("*");
    querChild.setName("liujun1");
    querChild.setType("drf");

    // 设置子资源池路径
    SchedulableProperties scheduleChildPro = new SchedulableProperties();

    scheduleChildPro.setScheduleName("default");
    scheduleChildPro.setWeight(1.0f);
    scheduleChildPro.setMaxResources(getResource(2, 2048));
    scheduleChildPro.setMinResources(getResource(2, 2048));

    querChild.getSchedulablePropertiesList().add(scheduleChildPro);
    // 添加资源池
    newPoolRes.getQueues().add(querChild);

    polls.get(0).getQueues().add(newPoolRes);

    dynmicSfvCfg.setValue(GSON.toJson(objValue));

    // 进行动态资源池的添加
    YarnApiV16.INSTANCE.allotDynmicResourceAdd(resourceV16, dynmicSfvCfg, clusterName);
  }

  private Resource getResource(int vcore, int memory) {
    Resource resource = new Resource();

    resource.setVcores(vcore);
    resource.setMemory(memory);

    return resource;
  }
}
