package com.liujun.cdh.operate.hdfs;

import com.liujun.cdh.operate.constant.HadoopCfgEnum;
import com.liujun.cdh.operate.constant.PropertyEnum;
import com.liujun.cdh.operate.constant.SysConfigEnum;
import com.liujun.cdh.operate.utils.CloseUtils;
import com.liujun.cdh.operate.utils.PropertiesUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.SecurityUtil;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 进行hdfs的数据的读写操作
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/03/29
 */
public class KerberosHdfsApi extends HdfsApi {

  public static final KerberosHdfsApi INSTANCE = new KerberosHdfsApi();

  /** kerberos的路径 */
  private static final String KERBEROS_CFG_PATH =
      PropertiesUtils.getInstance().getValue(PropertyEnum.KERBEROS_CFG_PATH);

  /** kerberos的登录用户 */
  private static final String KERBEROS_CFG_USER =
      PropertiesUtils.getInstance().getValue(PropertyEnum.KERBEROS_AUTH_USER);

  /** kerberos的用户密钥信息 */
  private static final String KERBEROS_CFG_KEYTAB =
      PropertiesUtils.getInstance().getValue(PropertyEnum.KERBEROS_AUTH_KEYTAB);

  /** hdfs-site.xml文件路径 */
  private static final String HDFS_SITE_FILE =
      PropertiesUtils.getInstance().getValue(PropertyEnum.HADOOP_CFG_HDFSITE);

  /** core-site文件路径 */
  private static final String CORE_SITE_FILE =
      PropertiesUtils.getInstance().getValue(PropertyEnum.HADOOP_CFG_CORESITE);

  static {
    // 设置kerberos的krb5.conf的路径
    System.setProperty(HadoopCfgEnum.HADOOP_KRB5_PATH.getKey(), KERBEROS_CFG_PATH);
  }

  /** file log */
  private Logger logger = LoggerFactory.getLogger(KerberosHdfsApi.class);

  /**
   * get hadoop file system object.
   *
   * @return fileSystem
   * @throws IOException IOException
   */
  @Override
  public FileSystem getFs(String uri) throws IOException {

    if (null == uri) {
      throw new IllegalArgumentException("hdfs uri  is  null");
    }

    Configuration conf = new Configuration();

    conf.set(HadoopCfgEnum.HDFS_DEFAULTFS.getKey(), uri);

    //加载hdfs-site.xml和core-site.xml文件
    conf.addResource(new Path(HDFS_SITE_FILE));
    conf.addResource(new Path(CORE_SITE_FILE));

    // 设置kerberos配置信息
    conf.setBoolean(HadoopCfgEnum.HADOOP_SECURITY_AUTHENTICATION.getKey(), true);
    conf.set(
        HadoopCfgEnum.HADOOP_SECURITY_AUTHENTICATION.getKey(),
        HadoopCfgEnum.HADOOP_SECURITY_AUTHENTICATION.getValue());

    try {
      // 设置配制信息
      UserGroupInformation.setConfiguration(conf);

      // kerberos 认证
      UserGroupInformation.loginUserFromKeytab(KERBEROS_CFG_USER, KERBEROS_CFG_KEYTAB);
      UserGroupInformation.getLoginUser();

      return FileSystem.get(conf);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("KerberosHdfsApi getFs IOException", e);
      throw e;
    }
  }
}
