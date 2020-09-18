package com.objectandclass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/9/7 20:28 .
 * @Description .
 */

public class ReloadTest {
  public String name;
  public int age;

  public ReloadTest() {
    this.age = 0;
  }

  public ReloadTest(final String name) {
    this.name = name;
    this.age = 0;
  }

  public ReloadTest(final String name, final int age) {
    this.name = name;
    this.age = age;
  }
}

class Test {
  public static void main(final String[] args) {
    final ReloadTest reload = new ReloadTest();
    System.out.println(reload.name);
    final ReloadTest test1 = new ReloadTest("诚诚", 12);
    System.out.println("name:" + test1.name + ",age: " + test1.age);
  }
}
