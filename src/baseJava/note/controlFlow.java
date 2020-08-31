package baseJava.note;
/*
 * @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/11 21:01.
 */

import java.util.Scanner;

public class controlFlow {
  public static void main(final String[] args) {
    // 多重选择switch
    System.out.println("write your number");
    final Scanner scan = new Scanner(System.in);
    final int num = scan.nextInt();
    switch (num) {
      case 1:
        {
          System.out.println(1);
          System.out.println("hi 1");
          break;
        }
      case 2:
        {
          System.out.println(2);
          System.out.print("hi 2");
          break;
        }
      default:
        {
          System.out.println("this is default");
          break;
        }
    }
  }
}
