package com.basejava.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/23 16:37.
 * @Description 一个简单的抽奖机
 */

import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
  public static void main(final String[] args) {
    final Scanner scan = new Scanner(System.in);
    System.out.println("你需要的总共的数字");
    final int all = scan.nextInt();
    System.out.println("抽奖的数字");
    final int num = scan.nextInt();
    final int[] allAry = new int[all];
    for (int i = 0; i < all; i++) {
      allAry[i] = i + 1;
    }
    final int[] prizes = new int[num];
    for (int i = 0; i < prizes.length; i++) {
      final int winnNumber = (int) Math.round(Math.random() * (all - 1));
      if (!useLoop(prizes, allAry[winnNumber])) {
        prizes[i] = allAry[winnNumber];
      } else {
        i--;
      }
      //      if (!useList(prizes, allAry[winnNumber])) {
      //        prizes[i] = allAry[winnNumber];
      //      } else {
      //        i--;
      //      }
    }
    Arrays.sort(prizes);
    System.out.println(Arrays.toString(prizes));
  }

  public static boolean useLoop(final int[] ary, final int num) {
    for (final int k : ary) {
      if (k == num) {
        return true;
      }
    }
    return false;
  }

  public static boolean useList(final int[] ary, final int num) {
    return Arrays.asList(ary).contains(num);
  }
}
