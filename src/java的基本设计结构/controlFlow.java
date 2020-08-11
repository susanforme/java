package java的基本设计结构;
/*
 * @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/11 21:01.
 */

public class controlFlow {
  public static void main(final String[] args) {
    // 循环
    int count = 0;
    while (Math.random() > 0.5) {
      System.out.println(++count);
    }
  }
}
