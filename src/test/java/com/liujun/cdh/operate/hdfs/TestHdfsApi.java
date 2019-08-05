package com.liujun.cdh.operate.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * 进行hdfs的api修改
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/05
 */
public class TestHdfsApi {

  @Test
  public void testGetList() throws IOException {
    String fs = "hdfs://hadoop1.paraview.cn:8020";

    FileSystem fsInst = KerberosHdfsApi.INSTANCE.getFs(fs);

    String path = "/liujun/user";

    boolean exists = KerberosHdfsApi.INSTANCE.exists(path, fsInst);
    Assert.assertEquals(true, exists);

    long length =
        KerberosHdfsApi.INSTANCE.getFileLength("/liujun/user/output/part-r-00000", fsInst);
    Assert.assertEquals(4424, length);
  }
}
