package com.liujun.cdh.operate.utils;

import org.apache.hadoop.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http的接口实例
 *
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/13
 */
public class HttpAdapter {

  public static final HttpAdapter INSTANCE = new HttpAdapter();

  public String sendGet(String url) {

    StringBuilder result = new StringBuilder();

    HttpClient client = HttpClientBuilder.create().build();

    InputStreamReader input = null;
    BufferedReader rd = null;

    try {
      HttpGet request = new HttpGet(url);

      // add request header
      request.addHeader("Content-Type", ContentType.APPLICATION_JSON.getMimeType());
      HttpResponse response = client.execute(request);

      if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {

        input = new InputStreamReader(response.getEntity().getContent());

        rd = new BufferedReader(input);

        String line;
        while ((line = rd.readLine()) != null) {
          result.append(line);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      close(rd);
      close(input);

    }

    return result.toString();
  }

  private static void close(Closeable able) {
    if (null != able) {
      try {
        able.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
