package com.liujun.cdh.operate.yarn;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liujun
 * @version 0.0.1
 * @date 2019/08
 */
public class TestInvoke {

  public static void main(String[] args)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException,
          NoSuchMethodException, InvocationTargetException {
    TestNewObject inst = new TestNewObject();
    inst.setName("12312q");
    System.out.println(inst.getName());

    Class classObj = Class.forName("com.liujun.cdh.operate.yarn.TestNewObject");
    Field[] fields = classObj.getDeclaredFields();

    for (Field fi : fields) {
      System.out.println(fi);
    }

    Method[] meoBj = classObj.getDeclaredMethods();
    for (Method fis : meoBj) {
      System.out.println(fis);
    }

    Object instances = classObj.newInstance();

    Method method = classObj.getDeclaredMethod("setName", String.class);

    method.invoke(instances, "刘军");

    TestNewObject obj = (TestNewObject) instances;
    System.out.println(obj.getName());
  }
}
