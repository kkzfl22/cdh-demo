package com.liujun.cdh.operate.yarn;

import com.cloudera.api.ClouderaManagerClientBuilder;
import com.cloudera.api.DataView;
import com.cloudera.api.model.ApiClusterList;
import com.cloudera.api.model.ApiConfig;
import com.cloudera.api.model.ApiServiceConfig;
import com.cloudera.api.v16.RootResourceV16;
import com.cloudera.api.v16.ServicesResourceV16;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liujun.cdh.operate.yarn.dto.DynmicResPoolCfgBusi;

/**
 * V16的资源池操作
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/08
 */
public class YarnApiV16 {

  public static final YarnApiV16 INSTANCE = new YarnApiV16();

  /** yarn的名称信息 */
  private static final String YARN_NAME = "yarn";

  /** 动态资源池的名称 */
  private static final String YARN_DYNMIC_NAME = "yarn_fs_scheduled_allocations";

  /** 进行json操作的对象 */
  private static final Gson GSON = new GsonBuilder().serializeNulls().create();

  /**
   * 获取最基础的资源操作对象
   *
   * @param host 远程的ip
   * @param port 端口
   * @param username 用户名
   * @param passwd 密码
   * @return 资源操作对象
   */
  public static RootResourceV16 getRootResource(
      String host, int port, String username, String passwd) {
    return new ClouderaManagerClientBuilder()
        .withHost(host)
        .withPort(port)
        .withUsernamePassword(username, passwd)
        .build()
        .getRootV16();
  }

  /**
   * 获取集群的名称
   *
   * @param root
   * @return
   */
  public String getClusterName(RootResourceV16 root) {
    ApiClusterList clusterList = root.getClustersResource().readClusters(DataView.SUMMARY);

    return clusterList.getClusters().get(0).getName();
  }

  public ApiConfig getDynmicServiceCfg(RootResourceV16 root, String clusterName) {
    ServicesResourceV16 resourceV16 = root.getClustersResource().getServicesResource(clusterName);
    ApiServiceConfig serviceConfig = resourceV16.readServiceConfig(YARN_NAME, DataView.FULL);

    if (null != serviceConfig) {
      for (ApiConfig appCfg : serviceConfig.getConfigs()) {
        if (YARN_DYNMIC_NAME.equals(appCfg.getName())) {
          return appCfg;
        }
      }
    }

    return null;
  }

  /** 添加动态资源池的资源 */
  public void allotDynmicResourceAdd(RootResourceV16 root, ApiConfig cfg, String clusterName) {

    ApiServiceConfig svrConfig = new ApiServiceConfig();
    svrConfig.add(cfg);

    ApiServiceConfig config =
        root.getClustersResource()
            .getServicesResource(clusterName)
            .updateServiceConfig(YARN_NAME, "update service config", svrConfig);

    // 进行资源池的刷新操作
    root.getClustersResource().poolsRefresh(clusterName);
  }
}
