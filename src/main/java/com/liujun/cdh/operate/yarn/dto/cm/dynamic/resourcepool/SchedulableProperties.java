package com.liujun.cdh.operate.yarn.dto.cm.dynamic.resourcepool;

/**
 * 调度的资源信息
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/08
 */
public class SchedulableProperties {

  /** impala的内存限制 */
  private Integer impalaDefaultQueryMemLimit;

  /** */
  private Integer impalaDefaultQueryOptions;

  private Integer impalaMaxMemory;

  private Integer impalaMaxQueuedQueries;

  private Integer impalaMaxRunningQueries;

  private Integer impalaQueueTimeout;

  private String maxAMShare;

  private Resource maxChildResources;

  /** 最大资源信息 */
  private Resource maxResources;

  /** 最大可并行的资源信息 */
  private Integer maxRunningApps;

  /** 最大的资源信息 */
  private Resource minResources;

  /** 调度的名称default */
  private String scheduleName;

  /** Share of resources relative to other pools. */
  private Float weight;

  public Integer getImpalaDefaultQueryMemLimit() {
    return impalaDefaultQueryMemLimit;
  }

  public void setImpalaDefaultQueryMemLimit(Integer impalaDefaultQueryMemLimit) {
    this.impalaDefaultQueryMemLimit = impalaDefaultQueryMemLimit;
  }

  public Integer getImpalaDefaultQueryOptions() {
    return impalaDefaultQueryOptions;
  }

  public void setImpalaDefaultQueryOptions(Integer impalaDefaultQueryOptions) {
    this.impalaDefaultQueryOptions = impalaDefaultQueryOptions;
  }

  public Integer getImpalaMaxMemory() {
    return impalaMaxMemory;
  }

  public void setImpalaMaxMemory(Integer impalaMaxMemory) {
    this.impalaMaxMemory = impalaMaxMemory;
  }

  public Integer getImpalaMaxQueuedQueries() {
    return impalaMaxQueuedQueries;
  }

  public void setImpalaMaxQueuedQueries(Integer impalaMaxQueuedQueries) {
    this.impalaMaxQueuedQueries = impalaMaxQueuedQueries;
  }

  public Integer getImpalaMaxRunningQueries() {
    return impalaMaxRunningQueries;
  }

  public void setImpalaMaxRunningQueries(Integer impalaMaxRunningQueries) {
    this.impalaMaxRunningQueries = impalaMaxRunningQueries;
  }

  public Integer getImpalaQueueTimeout() {
    return impalaQueueTimeout;
  }

  public void setImpalaQueueTimeout(Integer impalaQueueTimeout) {
    this.impalaQueueTimeout = impalaQueueTimeout;
  }

  public String getMaxAMShare() {
    return maxAMShare;
  }

  public void setMaxAMShare(String maxAMShare) {
    this.maxAMShare = maxAMShare;
  }

  public Resource getMaxChildResources() {
    return maxChildResources;
  }

  public void setMaxChildResources(Resource maxChildResources) {
    this.maxChildResources = maxChildResources;
  }

  public Resource getMaxResources() {
    return maxResources;
  }

  public void setMaxResources(Resource maxResources) {
    this.maxResources = maxResources;
  }

  public Integer getMaxRunningApps() {
    return maxRunningApps;
  }

  public void setMaxRunningApps(Integer maxRunningApps) {
    this.maxRunningApps = maxRunningApps;
  }

  public Resource getMinResources() {
    return minResources;
  }

  public void setMinResources(Resource minResources) {
    this.minResources = minResources;
  }

  public String getScheduleName() {
    return scheduleName;
  }

  public void setScheduleName(String scheduleName) {
    this.scheduleName = scheduleName;
  }

  public Float getWeight() {
    return weight;
  }

  public void setWeight(Float weight) {
    this.weight = weight;
  }
}
