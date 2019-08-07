package com.liujun.cdh.operate.yarn;

import com.cloudera.api.ClouderaManagerClientBuilder;
import com.cloudera.api.DataView;
import com.cloudera.api.model.*;
import com.cloudera.api.v10.HostsResourceV10;
import com.cloudera.api.v16.RootResourceV16;
import com.cloudera.api.v16.ServicesResourceV16;
import com.cloudera.api.v17.RootResourceV17;
import com.cloudera.api.v17.ServicesResourceV17;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/07
 */
public class YarnV16Test {

  private Logger LOG = LoggerFactory.getLogger(YarnV16Test.class);

  private static RootResourceV16 APIROOT;

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
      System.out.println(cfgVs);
      System.out.println();

      if(cfgVs.getName().equals("yarn_fs_scheduled_allocations"))
      {
        System.out.println("找到对象");
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
}
