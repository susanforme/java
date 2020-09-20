package com.extendsclass.exercise;

import com.objectandclass.note.Employee;

import java.util.Objects;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/20/18:03 .
 * @Description 建议每个自定义类都添加toString方法
 */
public class HashEmployee extends Employee {
  public HashEmployee(String n, int a, double s) {
    super(n, a, s);
  }

  @Override
  public boolean equals(Employee other) {
    return Objects.equals(this.getName(), other.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getName());
  }

  /** 绝大多数的toString都遵循方法,类的名字,随后是一段括号括起来的字段值 */
  @Override
  public String toString() {
    // super.toString()
    return getClass().getName()
        + "[name="
        + super.getName()
        + ",age="
        + super.getAge()
        + ",salary="
        + super.getSalary()
        + "]";
  }
}

class HashEmployeeTest {
  public static void main(String[] args) {
    HashEmployee hash = new HashEmployee("诚诚", 12, 10000.01);
    // 只要对象与一个字符串通过操作符+,连接起来,java编译器就会自动调用toString方法,来获得字符串描述
    // 在println中传入对象,也会调用对象的toString方法,
    System.out.println(hash);
    System.out.println("-----------------");
    // java.io.PrintStream@1b6d3586 对象的类名和散列码
    System.out.println(System.out);
    int[] luckyNumber = {1, 2};
    // s:[I@4554617c 前缀i表明是一个整型数组跟着hash值,补救方法是调用Array.toString
    System.out.println("s:" + luckyNumber);
  }
}
