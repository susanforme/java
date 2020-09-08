package com.baseJava.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/24 21:26 .
 * @Description 利率生成计算
 */

public class CompoundInterest {
  public static void main(final String[] args) {
    final int YEARS = 10;
    final int INTEREST = 6;
    final double[][] balances = new double[INTEREST][YEARS];
    for (int k = 0; k < INTEREST; k++) {
      balances[k][0] = 10000;
    }
    for (int i = 0; i < balances.length; i++) {
      for (int j = 1; j < balances[i].length; j++) {
        final double lastYearMoney = balances[i][j - 1];
        balances[i][j] = lastYearMoney * (1.1 + 0.01 * i);
      }
    }
    for (final double[] k : balances) {
      for (final double j : k) {
        System.out.printf("%10.2f", j);
      }
      System.out.println("\n");
    }
    // System.out.println(Arrays.deepToString(balances));
  }
}
