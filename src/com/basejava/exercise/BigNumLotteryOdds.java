package com.basejava.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/15 21:03.
 * @Description 兼容大数的抽奖器.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumLotteryOdds {
  public static void main(final String[] args) {
    System.out.println("你需要最大的数");
    final Scanner scan = new Scanner(System.in);
    final int max = scan.nextInt();
    System.out.println("你希望抽出几个数");
    final int num = scan.nextInt();
    BigInteger odd = BigInteger.valueOf(1);
    scan.close();
    for (int i = 1; i <= num; i++) {
      odd = odd.multiply(BigInteger.valueOf(max - i + 1)).divide(BigInteger.valueOf(i));
    }
    System.out.println(odd);
  }
}
