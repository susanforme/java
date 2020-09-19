package com.extendsclass.exercise;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/19/16:43 .
 * @Description .
 */
public class EmployeeEquals {
  private String name;

  public EmployeeEquals(String name) {
    this.name = name;
  }

  // 声明的显示参数是Employee,并没有覆盖Object类的equals方法,因为签名不同,方法重载了
  @Override
  public boolean equals(Object other) {
    return other != null
        && getClass() == other.getClass()
        && getName() == ((EmployeeEquals) other).getName();
  }

  public String getName() {
    return this.name;
  }
}

class EmployeeEqualsTest {
  public static void main(String[] args) {
    EmployeeEquals employee = new EmployeeEquals("诚诚");
    EmployeeEquals employee2 = new EmployeeEquals("诚诚");
    System.out.println(employee.equals(employee2));
  }
}
