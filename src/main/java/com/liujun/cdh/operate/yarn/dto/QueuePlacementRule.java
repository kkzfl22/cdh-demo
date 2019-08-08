package com.liujun.cdh.operate.yarn.dto;

import java.util.List;

/**
 * 队列规则信息
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/08
 */
public class QueuePlacementRule {

  /** 创建者信息 */
  private Boolean create;

  /** 名称 */
  private String name;

  /** 队列 */
  private String queue;

  /** 规则集 */
  private List<QueuePlacementRule> rules;

  public Boolean getCreate() {
    return create;
  }

  public void setCreate(Boolean create) {
    this.create = create;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQueue() {
    return queue;
  }

  public void setQueue(String queue) {
    this.queue = queue;
  }

  public List<QueuePlacementRule> getRules() {
    return rules;
  }

  public void setRules(List<QueuePlacementRule> rules) {
    this.rules = rules;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("QueuePlacementRule{");
    sb.append("create='").append(create).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", queue='").append(queue).append('\'');
    sb.append(", rules=").append(rules);
    sb.append('}');
    return sb.toString();
  }
}
