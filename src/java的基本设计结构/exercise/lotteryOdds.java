package java的基本设计结构.exercise;
/*
 * @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/13 21:00.
 * @Description 这个程序用来计算抽奖中奖的概率。例如， 如果必须从 1 ~ 50 之间的数字中取 6 个数字来抽奖， 那么会有 (50 x 49 x 48 x 47 x
 * 46 x 45)/(1 x 2 x 3 x 4 x 5 x 6) 种可能的结果， 所以中奖的几率是 1/15 890700。祝你好运！
 */

import java.util.Scanner;

public class lotteryOdds {
  public static void main(final String[] args) {
    System.out.println("你需要最大的数是什么:\n");
    final Scanner scan = new Scanner(System.in);
    final int max = scan.nextInt();
    System.out.println("你想要抽几个数");
    final int num = scan.nextInt();
    // 关闭输入器
    scan.close();
    // 共有多少种方法
    double odds = 1;
    for (int i = 1; i <= num; i++) {
      /* ((max - i + 1) / i);  (max - i + 1) / i: 浮点上下文中的整数除法,两个整数相除，结果必定是整数，
      如果用float、double等数据类型接收，语法上不构成错误，但是会丢失精度。
      int a =1;
      int b=2;
      double c = a/b;  0.0 */
      odds = odds * (max - i + 1) / i;
    }
    System.out.println(1 / odds);
  }
}
