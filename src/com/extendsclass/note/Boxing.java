package com.extendsclass.note;

import java.util.ArrayList;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/21/21:15 .
 * @Description .
 */
public class Boxing {
  public static void main(String[] args) {
    // 所以定义一个整型数组列表,但是菱形语法中只能传递类,而不能是基本数据类型如int
    ArrayList<Integer> someNum = new ArrayList<>();
    // 在这里会触发一个装箱操作
    someNum.add(1);
    // 等同于,称之为自动装箱
    someNum.add(Integer.valueOf(2));
    // 相反的是,给定一个int,会自动转为Integer
    int x = someNum.get(1);
    int y = someNum.get(1).intValue();
    // 但是==检测的包装器对象的内存位置
    Integer a = 1000;
    Integer b = 1000;
    // false,如果a,b小于100就会成功
    System.out.println(a == b);
    System.out.println(Boxing.max(new double[] {1, 2, 3}));
  }

  public static double max(double... x) {
    if (x.length == 0) {
      throw new Error("不要传空数组啊");
    }
    double max = x[0];
    for (double v : x) {
      if (v > max) {
        max = v;
      }
    }
    return max;
  }
}
