package java的基本设计结构.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/19 20:34.
 * @Description java数组
 */

import java.util.Arrays;

public class MyArray {
  public static void main(final String[] args) {
    // 数组排序
    final int[] a = new int[] {1, 2};
    System.out.print(Arrays.binarySearch(a, 0, a.length, 2));
  }
}
