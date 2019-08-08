package com.liujun.cdh.operate.yarn.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态资源池的根节点 root
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/08
 */
public class DynmicResPoolQueueRoot {

  /** Acl 管理应用的配制 一般为* */
  private String aclAdministerApps;

  /** acl提交的应用程序 */
  private String aclSubmitApps;

  /** */
  private String allowPreemptionFrom;

  /** 公平调度器的抢占阈值 */
  private Integer fairSharePreemptionThreshold;

  /** 公平调度器的抢占超时时间 */
  private Integer fairSharePreemptionTimeout;

  /** 调度器的抢占最小超时时间 */
  private Integer minSharePreemptionTimeout;

  /** 队列的名称 */
  private String name;

  /** */
  private List<DynmicResPoolQueueRoot> queues = new ArrayList<>();

  /** 调度相关的内容 */
  private List<SchedulableProperties> schedulablePropertiesList = new ArrayList<>();

  /**
   * 调度策略
   *
   * <p>drf
   */
  private String schedulingPolicy;

  /** 类型信息 :parent /null */
  private String type;

  public String getAclAdministerApps() {
    return aclAdministerApps;
  }

  public void setAclAdministerApps(String aclAdministerApps) {
    this.aclAdministerApps = aclAdministerApps;
  }

  public String getAclSubmitApps() {
    return aclSubmitApps;
  }

  public void setAclSubmitApps(String aclSubmitApps) {
    this.aclSubmitApps = aclSubmitApps;
  }

  public String getAllowPreemptionFrom() {
    return allowPreemptionFrom;
  }

  public void setAllowPreemptionFrom(String allowPreemptionFrom) {
    this.allowPreemptionFrom = allowPreemptionFrom;
  }

  public Integer getFairSharePreemptionThreshold() {
    return fairSharePreemptionThreshold;
  }

  public void setFairSharePreemptionThreshold(Integer fairSharePreemptionThreshold) {
    this.fairSharePreemptionThreshold = fairSharePreemptionThreshold;
  }

  public Integer getFairSharePreemptionTimeout() {
    return fairSharePreemptionTimeout;
  }

  public void setFairSharePreemptionTimeout(Integer fairSharePreemptionTimeout) {
    this.fairSharePreemptionTimeout = fairSharePreemptionTimeout;
  }

  public Integer getMinSharePreemptionTimeout() {
    return minSharePreemptionTimeout;
  }

  public void setMinSharePreemptionTimeout(Integer minSharePreemptionTimeout) {
    this.minSharePreemptionTimeout = minSharePreemptionTimeout;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<DynmicResPoolQueueRoot> getQueues() {
    return queues;
  }

  public void setQueues(List<DynmicResPoolQueueRoot> queues) {
    this.queues = queues;
  }

  public String getSchedulingPolicy() {
    return schedulingPolicy;
  }

  public void setSchedulingPolicy(String schedulingPolicy) {
    this.schedulingPolicy = schedulingPolicy;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<SchedulableProperties> getSchedulablePropertiesList() {
    return schedulablePropertiesList;
  }

  public void setSchedulablePropertiesList(List<SchedulableProperties> schedulablePropertiesList) {
    this.schedulablePropertiesList = schedulablePropertiesList;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("DynmicResPoolQueueRoot{");
    sb.append("aclAdministerApps='").append(aclAdministerApps).append('\'');
    sb.append(", aclSubmitApps='").append(aclSubmitApps).append('\'');
    sb.append(", allowPreemptionFrom='").append(allowPreemptionFrom).append('\'');
    sb.append(", fairSharePreemptionThreshold=").append(fairSharePreemptionThreshold);
    sb.append(", fairSharePreemptionTimeout=").append(fairSharePreemptionTimeout);
    sb.append(", minSharePreemptionTimeout=").append(minSharePreemptionTimeout);
    sb.append(", name='").append(name).append('\'');
    sb.append(", queues=").append(queues);
    sb.append(", schedulablePropertiesList=").append(schedulablePropertiesList);
    sb.append(", schedulingPolicy='").append(schedulingPolicy).append('\'');
    sb.append(", type='").append(type).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
