package com.liujun.cdh.operate.yarn.dto;

/**
 * 资源信息
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/08
 */
public class Resource {

  /** 内存信息 */
  private Integer memory;

  /** 虚拟的CPU信息 */
  private Integer vcores;

  public Integer getMemory() {
    return memory;
  }

  public void setMemory(Integer memory) {
    this.memory = memory;
  }

  public Integer getVcores() {
    return vcores;
  }

  public void setVcores(Integer vcores) {
    this.vcores = vcores;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Resource{");
    sb.append("memory=").append(memory);
    sb.append(", vcores=").append(vcores);
    sb.append('}');
    return sb.toString();
  }
}
