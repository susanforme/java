package com.objectandclass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/9/2 21:03 .
 * @Description 测试在java中参数的传递是按值还是引用传递
 */

import com.objectandclass.note.Employee;

public class ParamTest {
  public static void main(final String[] args) {
    // 测试传递对象副本的引用是否是同一个
    final Employee employee = new Employee("诚诚", 18, 12000);
    System.out.println("传值前:" + employee.getSalary());
    riseSalary(employee);
    System.out.println("传值后" + employee.getSalary());

    // 简单数值类型
    final int x = 1;
    System.out.println("传值前:" + x);
    triThree(x);
    System.out.println("传值后:" + x);

    // 校验是否能交换两个对象
    final Employee e1 = new Employee("诚诚", 18, 12000);
    final Employee e2 = new Employee("糖糖", 17, 12000);
    System.out.println("传值前:" + e1.logAllMsg());
    swap(e1, e2);
    System.out.println("传值后:" + e1.logAllMsg());
  }

  public static void riseSalary(final Employee e) {
    e.riseSalary();
  }

  public static void triThree(int x) {
    x *= 3;
  }

  public static void swap(Employee e1, Employee e2) {
    final Employee e = e1;
    e1 = e2;
    e2 = e;
  }
}
