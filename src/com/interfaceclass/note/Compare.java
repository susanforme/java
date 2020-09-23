package com.interfaceclass.note;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/23/20:16 .
 * @Description .
 */

import com.extendsclass.exercise.HashEmployee;

import java.util.Arrays;

public interface Compare<T> {
  // 自动是public
  public int compareTo(T o);
}

class EmployeeWithInterface extends HashEmployee implements Comparable<EmployeeWithInterface> {

  public EmployeeWithInterface(final String n, final int a, final double s) {
    super(n, a, s);
  }

  /**
   * 必须满足 x.compareTo(y)+y.compareTo(x) = 0
   *
   * @param other 另一个对象
   * @return 返回整数
   */
  public int compareTo(final EmployeeWithInterface other) {
    return Integer.compare(super.getAge(), other.getAge());
  }
}

class InterfaceTest {
  public static void main(final String[] args) {
    final EmployeeWithInterface e = new EmployeeWithInterface("cheng", 12, 12);
    final EmployeeWithInterface e2 = new EmployeeWithInterface("two", 13, 123);
    final EmployeeWithInterface e3 = new EmployeeWithInterface("one", 11, 11);
    final EmployeeWithInterface[] employeeWithInterfaces = {e, e2, e3};
    System.out.println(e.compareTo(e2));
    Arrays.sort(employeeWithInterfaces);
    System.out.println(Arrays.toString(employeeWithInterfaces));
  }
}
