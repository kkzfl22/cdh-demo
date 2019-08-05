package com.liujun.cdh.operate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭公共方法
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/03/03
 */
public class CloseUtils {

  /** 日志 */
  private static final Logger LOGGER = LoggerFactory.getLogger(CloseUtils.class);

  public static void close(Closeable close) {
    if (close != null) {
      try {
        close.close();
      } catch (IOException e) {
        e.printStackTrace();
        LOGGER.error("CloseUtils close IOException", e);
      }
    }
  }
}
