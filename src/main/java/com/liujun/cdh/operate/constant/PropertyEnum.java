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

  /** kerberos的用户 */
  KERBEROS_AUTH_USER("kerberos.username"),

  /** kerberos的用户认证密码 */
  KERBEROS_AUTH_KEYTAB("kerberos.keytab"),

  /** hdfs-site.xml文件的路径 */
  HADOOP_CFG_HDFSITE("hadoop.cfg.hdfssite"),

  /** 进行core-site.xml */
  HADOOP_CFG_CORESITE("hadoop.cfg.coresite"),
  ;

  private String key;

  PropertyEnum(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}
