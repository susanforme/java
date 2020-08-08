package java的基本设计结构;

import static java.lang.System.out;

// 枚举类型,必须生成到主类的外面
enum Size {
  LARGE,
  MIDDLE,
  SMALL
}

public class FirstSample {
  // 类常量,可以再这个类中多个方法使用
  public static final double MY_PI = 3.14;
  // 入口文件
  public static void main(final String[] args) {
    final String str = "我有一头小毛驴,我从来也不骑.";
    final int[] codePoints = str.codePoints().toArray(); // 生成int值的流
    final String str2 = new String(codePoints, 0, codePoints.length); // 将码点数组转换为字符串
    out.println(codePoints.toString()); // [I@4411d970
    out.println(str2); // 我有一头小毛驴,我从来也不骑.
  }
}
