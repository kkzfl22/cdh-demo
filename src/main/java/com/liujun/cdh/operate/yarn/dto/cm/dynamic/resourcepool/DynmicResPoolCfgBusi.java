package com.liujun.cdh.operate.yarn.dto.cm.dynamic.resourcepool;

import java.util.List;

/**
 * 动态资源池的信息
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/08
 */
public class DynmicResPoolCfgBusi {

  /** 默认公平调度器的抢占阈值 */
  private Integer defaultFairSharePreemptionThreshold;

  /** 默认公平调度器的抢占超时时间 */
  private Integer defaultFairSharePreemptionTimeout;

  /** 默认调度器的抢占最小超时时间 */
  private Integer defaultMinSharePreemptionTimeout;

  /** 默认队列调度策略,"fair" */
  private String defaultQueueSchedulingPolicy;

  /** AM共享队列的的最大的默认值 */
  private Float queueMaxAMShareDefault;

  /** 应用队列的最大默认值 */
  private Integer queueMaxAppsDefault;

  /** 队列的配制规则 */
  private List<QueuePlacementRule> queuePlacementRules;

  /** 任务池队列信息 */
  private List<DynmicResPoolQueueRoot> queues;

  /** */
  private String userMaxAppsDefault;

  private List<User> users;

  public Integer getDefaultFairSharePreemptionThreshold() {
    return defaultFairSharePreemptionThreshold;
  }

  public void setDefaultFairSharePreemptionThreshold(Integer defaultFairSharePreemptionThreshold) {
    this.defaultFairSharePreemptionThreshold = defaultFairSharePreemptionThreshold;
  }

  public Integer getDefaultFairSharePreemptionTimeout() {
    return defaultFairSharePreemptionTimeout;
  }

  public void setDefaultFairSharePreemptionTimeout(Integer defaultFairSharePreemptionTimeout) {
    this.defaultFairSharePreemptionTimeout = defaultFairSharePreemptionTimeout;
  }

  public Integer getDefaultMinSharePreemptionTimeout() {
    return defaultMinSharePreemptionTimeout;
  }

  public void setDefaultMinSharePreemptionTimeout(Integer defaultMinSharePreemptionTimeout) {
    this.defaultMinSharePreemptionTimeout = defaultMinSharePreemptionTimeout;
  }

  public String getDefaultQueueSchedulingPolicy() {
    return defaultQueueSchedulingPolicy;
  }

  public void setDefaultQueueSchedulingPolicy(String defaultQueueSchedulingPolicy) {
    this.defaultQueueSchedulingPolicy = defaultQueueSchedulingPolicy;
  }

  public Float getQueueMaxAMShareDefault() {
    return queueMaxAMShareDefault;
  }

  public void setQueueMaxAMShareDefault(Float queueMaxAMShareDefault) {
    this.queueMaxAMShareDefault = queueMaxAMShareDefault;
  }

  public Integer getQueueMaxAppsDefault() {
    return queueMaxAppsDefault;
  }

  public void setQueueMaxAppsDefault(Integer queueMaxAppsDefault) {
    this.queueMaxAppsDefault = queueMaxAppsDefault;
  }

  public List<QueuePlacementRule> getQueuePlacementRules() {
    return queuePlacementRules;
  }

  public void setQueuePlacementRules(List<QueuePlacementRule> queuePlacementRules) {
    this.queuePlacementRules = queuePlacementRules;
  }

  public List<DynmicResPoolQueueRoot> getQueues() {
    return queues;
  }

  public void setQueues(List<DynmicResPoolQueueRoot> queues) {
    this.queues = queues;
  }

  public String getUserMaxAppsDefault() {
    return userMaxAppsDefault;
  }

  public void setUserMaxAppsDefault(String userMaxAppsDefault) {
    this.userMaxAppsDefault = userMaxAppsDefault;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("DynmicResPoolCfgBusi{");
    sb.append("defaultFairSharePreemptionThreshold=").append(defaultFairSharePreemptionThreshold);
    sb.append(", defaultFairSharePreemptionTimeout=").append(defaultFairSharePreemptionTimeout);
    sb.append(", defaultMinSharePreemptionTimeout=").append(defaultMinSharePreemptionTimeout);
    sb.append(", defaultQueueSchedulingPolicy='").append(defaultQueueSchedulingPolicy).append('\'');
    sb.append(", queueMaxAMShareDefault=").append(queueMaxAMShareDefault);
    sb.append(", queueMaxAppsDefault=").append(queueMaxAppsDefault);
    sb.append(", queuePlacementRules=").append(queuePlacementRules);
    sb.append(", queues=").append(queues);
    sb.append(", userMaxAppsDefault='").append(userMaxAppsDefault).append('\'');
    sb.append(", users=").append(users);
    sb.append('}');
    return sb.toString();
  }
}
