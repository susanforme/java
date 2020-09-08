package com.baseJava.exercise;
/*
 * @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/11 21:13.
 * @Description 将计算需要多长时间才能够存储一定数量的退休金，假定每年存
 * 人相同数量的金额，而且利率是固定的。
 */

import java.util.Scanner;

public class Retirement {
  public static void main(final String[] args) {
    final Scanner scan = new Scanner(System.in);
    // 需要存入的钱
    System.out.print("How much money do you need to retire? ");
    final double money = scan.nextDouble();
    System.out.print("How much money will you contribute every year? ");
    final double perYearMoney = scan.nextDouble();
    // 关闭输入器
    scan.close();
    // 利率
    final double rate = 0.03;
    int year = 0;
    double balance = 0.0;
    while (balance < money) {
      balance = balance * (1 + rate) + perYearMoney;
      year++;
    }
    System.out.println(year + "years");
  }
}
