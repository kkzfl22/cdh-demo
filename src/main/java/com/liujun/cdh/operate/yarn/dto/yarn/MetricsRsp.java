package com.liujun.cdh.operate.yarn.dto.yarn;

/**
 * 资源信息查看
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/13
 */
public class MetricsRsp {

  private Metrics clusterMetrics;

  public Metrics getClusterMetrics() {
    return clusterMetrics;
  }

  public void setClusterMetrics(Metrics clusterMetrics) {
    this.clusterMetrics = clusterMetrics;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("MetricsRsp{");
    sb.append("clusterMetrics=").append(clusterMetrics);
    sb.append('}');
    return sb.toString();
  }
}
