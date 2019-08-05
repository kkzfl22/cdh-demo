package com.liujun.cdh.operate.constant;

/**
 * hadoop的相关配制信息
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/05
 */
public enum HadoopCfgEnum {

  /** hdfs的连接地址信息 */
  HDFS_DEFAULTFS("fs.defaultFS", null),

  /** 启用kerberos的标识 */
  HADOOP_SECURITY_AUTHENTICATION("hadoop.security.authentication", "kerberos"),

  /** kerberos的配制路径 */
  HADOOP_KRB5_PATH("java.security.krb5.conf", null);
  ;

  /** 配制的key信息 */
  private String key;

  /** 值信息 */
  private String value;

  HadoopCfgEnum(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
