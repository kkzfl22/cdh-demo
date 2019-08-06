package com.liujun.cdh.operate.constant;

/**
 * 属性文件的枚举对象
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/03/01
 */
public enum PropertyEnum {

  /** hdfs的filesystem的地址 */
  HDFS_FILESYSTEM_URL("hdfs.fs.url"),

  /** kerberos 的conf 的配制路径 */
  KERBEROS_CFG_PATH("kerberos.conf.path"),

  /** hdfs-site.xml文件的路径 */
  HADOOP_CFG_HDFSITE("hadoop.cfg.hdfssite"),

  /** 进行core-site.xml */
  HADOOP_CFG_CORESITE("hadoop.cfg.coresite"),

  /** kerberos的用户 */
  KERBEROS_AUTH_USER("kerberos.username"),

  /** kerberos的keytab文件 */
  KERBEROS_AUTH_KEYTAB("kerberos.keytab"),

  /** kerberos的超级管理员用户 */
  KERBEROS_AUTH_SUPER_USER("kerberos.super.username"),

  /** kerberos的超级管理员管理员的keytab文件 */
  KERBEROS_AUTH_SUPER_KEYTAB("kerberos.super.keytab"),
  ;

  private String key;

  PropertyEnum(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
