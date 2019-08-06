package com.liujun.cdh.operate.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.QuotaUsage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

/**
 * 进行hdfs的api修改
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/05
 */
public class TestKerberosHdfsApi {

  private static FileSystem fileSystem;

  @BeforeClass
  public static void beforeGetFs() {
    try {
      String fs = "hdfs://hadoop1.paraview.cn:8020";

      fileSystem = KerberosHdfsApi.INSTANCE.getFs(fs);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetList() throws IOException {

    String path = "/liujun/user";

    boolean exists = KerberosHdfsApi.INSTANCE.exists(path, fileSystem);
    Assert.assertEquals(true, exists);

    long length =
        KerberosHdfsApi.INSTANCE.getFileLength("/liujun/user/output/part-r-00000", fileSystem);
    Assert.assertEquals(4424, length);
  }

  @Test
  public void testQuota() throws IOException {
    String fs = "hdfs://hadoop1.paraview.cn:8020";

    String operatePath  = "/liujun/user/quota";

    FileSystem fsInst = KerberosHdfsApi.INSTANCE.getFs(fs);
    // 查询quota信息
    QuotaUsage qutaoinfo = KerberosHdfsApi.INSTANCE.getQuota(operatePath, fsInst);

    System.out.println("当前空间的总空间限制:" + qutaoinfo.getSpaceQuota());
    System.out.println("当前的已经使用空间:" + qutaoinfo.getSpaceConsumed());
    Assert.assertNotEquals(0, qutaoinfo.getSpaceConsumed());


    long newQuota = 512 * 1024 * 1024;

    //设置quota的大小为512M
    KerberosHdfsApi.INSTANCE.setQuota(fs, operatePath, newQuota);


    QuotaUsage qutaoinfoMax = KerberosHdfsApi.INSTANCE.getQuota(operatePath, fsInst);

    Assert.assertEquals(qutaoinfoMax.getQuota(),newQuota);
  }
}
