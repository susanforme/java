package com.basejava.exercise;
/*
 * @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/13 20:28.
 * @Description 首先计算退休账户中的余额 然后再询问是否打算退休：
 */

import java.util.Scanner;

public class Retirement2 {
  public static void main(final String[] args) {
    System.out.println("你每年存入银行的钱:");
    final Scanner scan = new Scanner(System.in);
    final double money = scan.nextDouble();
    final double interest = 0.03;
    double balance = 0;
    String answer = "no";
    do {
      balance = (balance + money) * (1 + interest);
      System.out.println("目前余额是" + balance + "想退休吗?yes or no.");
      answer = scan.next();
    } while (answer.equals("no"));
    // 关闭输入器
    scan.close();
  }
}
