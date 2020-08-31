package baseJava.note;

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
    /* 构建字符串,有时候需要较短字符串构建字符串,按键或者来自文件中的单词,采用字符串连接的效率较低,每次连接都会生成一个新的String对象,所以使用
    StringBuilder类,可以避免问题
    */
    final StringBuilder builder = new StringBuilder();
    builder.append("hello");
    builder.append("world");
    // 在需要使用字符串的时候调用toString方法
    final String completeStr = builder.toString();
    out.println(completeStr + ", " + builder.length());
  }
}
