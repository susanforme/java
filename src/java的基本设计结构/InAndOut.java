package java的基本设计结构;

import java.io.Console;
import java.util.Arrays;

/* @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/10 19:29.
 */

public class InAndOut {
  public static void main(final String[] args) {
    // 因为输入是可见的,所以Scanner类不适合从控制台读取密码,
    final Console cons = System.console(); // 不在命令行中调用为null
    if (cons != null) {
      final String username = cons.readLine("User name: ");
      final char[] passwd = cons.readPassword("password: ");
      System.out.println(username + Arrays.toString(passwd));
    } else {
      System.out.println("请在命令行中调用");
    }
  }
}
