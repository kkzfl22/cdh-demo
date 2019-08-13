package com.liujun.cdh.operate.yarn;

import com.google.gson.Gson;
import com.liujun.cdh.operate.utils.HttpAdapter;
import com.liujun.cdh.operate.yarn.dto.yarn.Metrics;
import com.liujun.cdh.operate.yarn.dto.yarn.MetricsRsp;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2019/08/13
 */
public class TestYarnMectric {

  private Gson gson = new Gson();

  @Test
  public void metric() {
    String url = "http://192.168.1.231:8088/ws/v1/cluster/metrics";
    String rsp = HttpAdapter.INSTANCE.sendGet(url);

    Assert.assertNotEquals(null, rsp);

    MetricsRsp metrics = gson.fromJson(rsp, MetricsRsp.class);

    System.out.println(metrics);
    Assert.assertNotEquals(null, metrics);
  }
}
