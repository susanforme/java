package java的基本设计结构;

import static java.lang.Math.*;
import static java.lang.System.out;

// 枚举类型,必须生成到主类的外面
enum Size {
  LARGE,
  MIDDLE,
  SMALL
};

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
    out.println(vacationDays * vacationDays * MY_PI);
    // 求平方根
    final double MY_SQRT_VACATION_DAYS = sqrt(vacationDays);
    out.println(MY_SQRT_VACATION_DAYS);
    // 幂
    out.println(pow(vacationDays, 2));
    // 强制类型转换,相当于Math.floor()
    final double x = 10.6;
    final int nx = (int) x;
    out.println(nx == floor(x));
    out.println(nx);
  }
}
