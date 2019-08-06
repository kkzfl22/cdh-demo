package com.liujun.cdh.operate.hdfs;

import com.liujun.cdh.operate.constant.HadoopCfgEnum;
import com.liujun.cdh.operate.constant.PropertyEnum;
import com.liujun.cdh.operate.constant.SysConfigEnum;
import com.liujun.cdh.operate.utils.CloseUtils;
import com.liujun.cdh.operate.utils.PropertiesUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.QuotaUsage;
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
public class HdfsApi {

  /** file log */
  private Logger logger = LoggerFactory.getLogger(HdfsApi.class);

  /** 默认的filesystem */
  private static final String FS_URL =
      PropertiesUtils.getInstance().getValue(PropertyEnum.HDFS_FILESYSTEM_URL);

  public static final HdfsApi INSTANCE = new HdfsApi();

  /**
   * get hadoop file system object.
   *
   * @return fileSystem
   * @throws IOException IOException
   */
  public FileSystem getFs(String uri) throws IOException {
    Configuration conf = new Configuration();
    if (uri != null) {
      conf.set(HadoopCfgEnum.HDFS_DEFAULTFS.getKey(), uri);
    }

    try {
      return FileSystem.get(conf);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi exists IOException", e);
      throw e;
    }
  }

  /**
   * 不带缓存的defaultfs操作
   *
   * @return
   */
  public FileSystem getDefaultFs() {

    Configuration conf = new Configuration();

    conf.set(HadoopCfgEnum.HDFS_DEFAULTFS.getKey(), FS_URL);

    try {
      return FileSystem.get(conf);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi exists IOException", e);
    }

    return null;
  }

  /**
   * 获取默认的filesystem的地址
   *
   * @return
   */
  public FileSystem getDefaultNewInstanceFs() {

    Configuration conf = new Configuration();

    conf.set(HadoopCfgEnum.HDFS_DEFAULTFS.getKey(), FS_URL);

    try {
      return FileSystem.newInstance(conf);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi exists IOException", e);
    }

    return null;
  }

  /**
   * 进行文件是否存在的检查
   *
   * @param path 路径信息
   * @param fs fs文件信息
   * @return true 文件存在 false 文件不存在
   */
  public boolean exists(String path, FileSystem fs) throws IOException {
    Path hdfsPath = new Path(path);

    try {
      return fs.exists(hdfsPath);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi exists IOException", e);
      throw e;
    }
  }

  /**
   * 检查并创建文件夹
   *
   * @param path
   * @param fs
   * @return
   */
  public void checkAndMkdir(String path, FileSystem fs) throws IOException {

    boolean exists = this.exists(path, fs);

    // 当文件不存在时，执行创建操作
    if (!exists) {
      this.mkdirs(path, fs);
    }
  }

  /**
   * 进行文件夹的创建操作
   *
   * @param path 文件路径
   * @param fs filesystem
   * @return true 创建成功 false 创建失败
   */
  public boolean mkdirs(String path, FileSystem fs) throws IOException {
    Path hdfsPath = new Path(path);
    try {
      return fs.mkdirs(hdfsPath);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi mkdirs IOException", e);
      throw e;
    }
  }

  /**
   * 获取文件大小
   *
   * @param path
   * @param fs
   * @return
   */
  public long getFileLength(String path, FileSystem fs) throws IOException {
    Path hdfsPath = new Path(path);
    try {
      return fs.getFileStatus(hdfsPath).getLen();
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi mkdirs IOException", e);
      throw e;
    }
  }

  /**
   * 检查设置的quota信息
   *
   * @param path
   * @param fs
   * @return
   * @throws IOException
   */
  public QuotaUsage getQuota(String path, FileSystem fs) throws IOException {
    Path hdfsPath = new Path(path);
    QuotaUsage qutainfo = fs.getQuotaUsage(hdfsPath);

    return qutainfo;
  }

  /**
   * 进行hdfs的文件删除操作
   *
   * @param path
   * @param fs
   * @return
   */
  public boolean delete(String path, FileSystem fs) throws IOException {
    Path hdfsPath = new Path(path);
    try {
      return fs.delete(hdfsPath, false);
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("HdfsApi delete IOException", e);
      throw e;
    }
  }

  /**
   * 获取文件流对象
   *
   * @param path 文件路径
   * @param fs
   * @return 流
   */
  public OutputStream getFileOutStream(String path, FileSystem fs) throws IOException {

    Path outputPath = new Path(path);

    return fs.create(outputPath);
  }

  /**
   * 获取文件流对象
   *
   * @param path 文件路径
   * @param fs
   * @return 流
   */
  public InputStream getFileInputStream(String path, FileSystem fs) throws IOException {

    Path inputPath = new Path(path);

    return fs.open(inputPath);
  }

  /**
   * 进行hdfs文件的写入操作
   *
   * @param input
   * @param hdfsOutputPath
   * @param fs
   * @throws IOException
   */
  public void write(InputStream input, String hdfsOutputPath, FileSystem fs) throws Exception {

    Path outputPath = new Path(hdfsOutputPath);

    OutputStream output = null;

    // 缓冲区的大小
    byte[] dataBuffer = new byte[SysConfigEnum.CONFIG_BUFFER_SIZE.getCfg()];

    BufferedInputStream buffStream = null;

    try {
      output = fs.create(outputPath);

      buffStream = new BufferedInputStream(input);

      int readIndex;
      while ((readIndex = buffStream.read(dataBuffer)) != -1) {
        output.write(dataBuffer, 0, readIndex);
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      CloseUtils.close(buffStream);
      CloseUtils.close(output);
      CloseUtils.close(input);
    }
  }
}
