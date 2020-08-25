package java的基本设计结构.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/19 20:34 .
 * @Description java数组 .
 */

public class MyArray {
  public static void main(final String[] args) {
    // 不规则数组
    final double[][] balances = new double[10][6];
    for (int i = 0; i < balances.length; i++) {
      for (int j = 0; j < balances[i].length; j++) {
        balances[i][j] = Math.random() * 100;
      }
    }
    for (final double[] k : balances) {
      for (final double j : k) {
        System.out.printf("%10.2f", j);
      }
      System.out.print("\n");
    }
  }
}
