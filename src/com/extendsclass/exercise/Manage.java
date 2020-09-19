package com.extendsclass.exercise;

import com.objectandclass.note.Employee;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/18/20:44 .
 * @Description .
 */
public class Manage extends Employee {
  private double bonus;

  public Manage(String n, int a, double s) {
    // 调用超类的构造器
    super(n, a, s);
    this.bonus = 0;
  }

  public void setBonus(double bonus) {
    // 调用当前类的属性
    this.bonus = bonus;
  }

  public double getSalary() {
    // 超类的方法
    return super.getSalary() + bonus;
  }
}

class Test {
  public static void main(String args[]) {
    Manage rzc = new Manage("冉志诚", 12, 8000);
    System.out.println(rzc.getSalary());
    rzc.setBonus(3000);
    System.out.println(rzc.getSalary());
    System.out.println("---------------------------");
    Manage[] someManage = new Manage[3];
    someManage[0] = rzc;
    someManage[1] = new Manage("Test", 11, 1222);
    someManage[2] = new Manage("getSalary", 1, 122);
    for (Manage manage : someManage) {
      // 输出的错误信息
      System.out.println(manage.logAllMsg());
    }
    System.out.println("---------------------------");
    System.out.println(someManage[1] instanceof Manage);
  }
}
