package com.objectAndClass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/31 21:25 .
 * @Description .
 */

import com.objectAndClass.note.Employee;

public class EmployeeTest {
  public static void main(final String[] args) {
    final Employee[] employees = new Employee[3];
    for (int i = 0; i < employees.length; i++) {
      employees[i] =
          new Employee(
              "诚诚", (int) Math.round(Math.random() * 20), Math.round(Math.random() * 3000));
    }
    for (final Employee e : employees) {
      System.out.println(e.getAge());
      System.out.println(e.logAllMsg());
    }
    for (final Employee e : employees) {
      System.out.println(e.riseSalary());
      System.out.println("id是: " + e.getId() + ",静态属性下一个id是: " + e.getNextId());
    }
    System.out.print(employees[0].equals(employees[1]));
  }
}
