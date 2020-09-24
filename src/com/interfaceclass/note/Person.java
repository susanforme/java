package com.interfaceclass.note;

import com.sun.istack.internal.NotNull;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/23/21:24 .
 * @Description .
 */
public interface Person {
  @NotNull
  String changeName(String x);
}

interface Employee extends Person {

  void raiseSalary(double salary);
  // 自动设置为public static,定义常量,在与业务强相关使用,不要在全局使用,全局使用final类
  double ALLOWANCE = 30.2;
}

interface Default {
  int size();
  // 默认方法,可以不用重写,默认继承该方法
  default boolean isEmpty() {
    return size() == 0;
  }

  default String logDefault() {
    return "default";
  }
}

interface Named {
  default String logDefault() {
    return "named";
  }
}

class DefaultTest implements Default, Named {
  @Override
  public int size() {
    return 0;
  }

  @Override
  public String logDefault() {
    return Default.super.logDefault();
  }
}

class PersonInterfaceTest implements Person {
  @Override
  public String changeName(final String x) {
    return "test" + x;
  }
}

class EmployeeInterfaceTest implements Employee {
  @Override
  public void raiseSalary(final double salary) {}

  @Override
  public String changeName(final String x) {
    System.out.println(Employee.ALLOWANCE);
    return "t" + x;
  }
}

class Test {
  public static void main(final String[] args) {
    final EmployeeInterfaceTest employeeInterfaceTest = new EmployeeInterfaceTest();
    System.out.println(employeeInterfaceTest.changeName("t"));
    final DefaultTest defaultTest = new DefaultTest();
    System.out.println(defaultTest.size());
    System.out.println(defaultTest.isEmpty());
  }
}
