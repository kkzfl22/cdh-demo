package com.liujun.cdh.operate.yarn;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2019/09j/07
 */
public class TestNewObject {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("TestNewObject{");
    sb.append("name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
