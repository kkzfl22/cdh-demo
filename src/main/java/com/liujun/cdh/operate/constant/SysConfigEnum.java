package com.liujun.cdh.operate.constant;

/**
 * 进行系统配制的枚举
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/04/03
 */
public enum SysConfigEnum {

  /** 字符缓冲区大小，设置为256K */
  CONFIG_BUFFER_SIZE(1024 * 256),
  ;

  /** 配制信息 */
  private int cfg;

  SysConfigEnum(int cfg) {
    this.cfg = cfg;
  }

  public int getCfg() {
    return cfg;
  }
}
