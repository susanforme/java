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
    // 数组初始化,匿名数组
    int[] smallPrimes = {2, 3, 4};
    smallPrimes = new int[] {1, 23};
    System.out.println(Arrays.toString(smallPrimes));
    // 数组拷贝,在拷贝的时候是拷贝的指针,指向引用的同一个数组,copyOf为深拷贝
    final int[] a = new int[] {1};
    final int[] b = Arrays.copyOf(a, a.length * 2); // 第二个参数是数组长度,如果数组是数值,
    // 多余的参数被赋值为0,布尔值则为false,小于长度则为截取的长度
    System.out.println(Arrays.toString(a)); // 1
    a[0] = 3;
    System.out.println(Arrays.toString(b)); // 1
    System.out.println(a == b); // false
  }
}
