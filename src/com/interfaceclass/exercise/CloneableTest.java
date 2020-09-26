package com.interfaceclass.exercise;

import com.extendsclass.exercise.HashEmployee;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/26/13:32 .
 * @Description .
 */
public class CloneableTest extends HashEmployee implements Cloneable {
  public CloneableTest(final String n, final int a, final double s) {
    super(n, a, s);
  }

  @Override
  public CloneableTest clone() throws CloneNotSupportedException {
    return (CloneableTest) super.clone();
  }
}

class CloneTest {
  public static void main(final String[] args) throws CloneNotSupportedException {
    final CloneableTest cloneableTest = new CloneableTest("诚诚", 12, 123.12);
    /* final HashEmployee hashEmployee = new HashEmployee("诚诚", 123, 123);
     * 对象不能直接调用clone,数组可以
     * hashEmployee.clone(); 报错
     */
    final CloneableTest test = cloneableTest;
    System.out.println(test == cloneableTest); // true
    System.out.println(cloneableTest.clone() == cloneableTest); // false
  }
}
