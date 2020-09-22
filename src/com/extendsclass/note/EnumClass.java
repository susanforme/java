package com.extendsclass.note;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/22/20:51 .
 * @Description 这是一个枚举类
 */

import java.util.Arrays;

// 枚举类
enum Size {
  SMALL("S"),
  LARGE("L");
  private String mySize;

  /** 枚举类的构造器总是私有的 ,可以省略private,如果声明其他修饰符则会报错 */
  Size(String s) {
    this.mySize = s;
  }

  public String getSize() {
    return this.mySize;
  }
}

public class EnumClass {
  public static void main(String args[]) {
    // 调用从Enum继承到的方法
    String whatSize = Size.SMALL.toString();
    System.out.println(whatSize);
    System.out.println(Size.LARGE.getSize());
    // Size的逆方法是valueOf
    Size s = Size.valueOf(whatSize);
    System.out.println(s);
    // values会返回包含所有枚举值的数组
    Size[] sizes = Size.values();
    System.out.println(Arrays.toString(sizes));
    // ordinal返回枚举常量的位置
    System.out.println(Size.SMALL.ordinal());
  }
}
