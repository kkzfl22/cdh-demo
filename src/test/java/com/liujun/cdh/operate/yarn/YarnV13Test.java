package com.liujun.cdh.operate.yarn;

import com.cloudera.api.ClouderaManagerClientBuilder;
import com.cloudera.api.DataView;
import com.cloudera.api.model.*;
import com.cloudera.api.v10.HostsResourceV10;
import com.cloudera.api.v13.RootResourceV13;
import com.cloudera.api.v13.ServicesResourceV13;
import com.cloudera.api.v3.RoleConfigGroupsResource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/07
 */
public class YarnV13Test {

  private Logger LOG = LoggerFactory.getLogger(YarnV13Test.class);

  private static RootResourceV13 APIROOT;

  @BeforeClass
  public static void getBase() {
    RootResourceV13 apiRoot =
        new ClouderaManagerClientBuilder()
            .withHost("192.168.1.231")
            .withPort(7180)
            .withUsernamePassword("admin", "admin")
            .build()
            .getRootV13();

    APIROOT = apiRoot;
  }

  @Test
  public void testYarn() {

    ApiClusterList clusters = APIROOT.getClustersResource().readClusters(DataView.SUMMARY);
    for (ApiCluster cluster : clusters) {
      System.out.println(cluster);
    }
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

  /** 配置 */
  @Test
  public void testRoleConfigGroupsResource() {

    ServicesResourceV13 serviceResourceV13 =
        APIROOT.getClustersResource().getServicesResource("cluster");

    ApiServiceList apiServiceList = serviceResourceV13.readServices(DataView.SUMMARY);

    for (ApiService service : apiServiceList) {

      System.out.println(service);

      System.out.println(service.getConfig());
    }

    System.out.println("============================================================");

    RoleConfigGroupsResource roleResouce = serviceResourceV13.getRoleConfigGroupsResource("yarn");

    ApiRoleConfigGroupList roles = roleResouce.readRoleConfigGroups();

    for (ApiRoleConfigGroup role : roles) {
      System.out.println(role);
      System.out.println("--------------------------------------------------------");
    }
  }

  @Test
  public void testYarnResourcePool() {
    ApiServiceList apiList =
        APIROOT.getClustersResource().getServicesResource("cluster").readServices(DataView.SUMMARY);

    for (ApiService service : apiList) {

      System.out.println(service);
    }
  }
}
