package objectAndClass.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/31 20:57 .
 * @Description .
 */

import java.util.Objects;

public class Employee {
  private final String name;
  private final int age;
  private double salary;
  /** 下一个id */
  private static int nextId = 0;
  /** 每个员工的id */
  private int id = 0;
  /** 静态常量,公司成立时间 */
  private static final int year = 2000;

  public Employee(final String n, final int a, final double s) {
    this.name = n;
    this.age = a;
    this.salary = s;
    this.id = nextId;
    nextId++;
  }
  /** 输出所有信息 */
  public String logAllMsg() {
    return "员工" + this.name + "年龄" + this.age + "的薪水是" + this.salary;
  }
  /** 年龄 */
  public int getAge() {
    return age;
  }
  /** 涨薪水,同时返回薪水 */
  public double riseSalary() {
    this.salary *= 1.05;
    return this.salary; // 可以不使用this,但是建议使用
  }
  /** 比较是否相等 */
  public boolean equals(final Employee other) {
    return Objects.equals(this.name, other.name);
  }
  /** 取得id */
  public int getId() {
    return this.id;
  }
  /** 下一个id是 */
  public int getNextId() {
    return nextId;
  }

  /** 返回薪水 */
  public double getSalary() {
    return this.salary;
  }
}
