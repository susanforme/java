package java的基本设计结构.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/19 20:34 .
 * @Description java数组 .
 */

import java.util.Arrays;

public class MyArray {
  public static void main(final String[] args) {
    // 多维数组
    final double[][] balances = new double[3][3];
    final double[][] magics = new double[][] {{1, 2, 3}, {1, 2, 3}};
    for (int i = 0; i < balances.length; i++) {
      for (int j = 0; j < balances[i].length; j++) {
        balances[i][j] = Math.random();
      }
    }
    System.out.println(Arrays.deepToString(balances));
    //    System.out.println(Arrays.deepToString(magics));
    for (final double[] i : magics) {
      for (final double j : i) {
        System.out.print(j + ", ");
      }
    }
  }
}
