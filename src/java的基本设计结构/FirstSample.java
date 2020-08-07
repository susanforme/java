package java的基本设计结构;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class FirstSample {
  // 类常量,可以再这个类中多个方法使用
  public static final double MY_PI = 3.14;
  // 入口文件
  public static void main(final String[] args) {
    // 用final声明的是常量,使用全大写
    final var ONLY_A_NUMBER = 3;
    System.out.println(ONLY_A_NUMBER);
    // 整型
    final int vacationDays = 12;
    System.out.println(vacationDays * vacationDays * MY_PI);
    // 求平方根
    final double MY_SQRT_VACATION_DAYS = sqrt(vacationDays);
    System.out.println(MY_SQRT_VACATION_DAYS);
    // 幂
    System.out.println(pow(vacationDays, 2));
    // 强制类型转换

  }
}
