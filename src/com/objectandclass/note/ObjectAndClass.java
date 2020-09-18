package com.objectandclass.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/26 20:18 .
 * @Description .
 */

import static java.lang.System.out;

public class ObjectAndClass {
  public static void main(final String[] args) {
    final Employee e1 = new Employee("s", 12, 123);
    final Employee e2 = new Employee("com/basejava", 11, 12323);
    swap(e1, e2);
    System.out.println(e1.logAllMsg());
    System.out.println(Employee.year);
    out.println();
  }

  public static void swap(Employee x, Employee y) {
    final Employee e = x;
    x = y;
    y = e;
  }
}
