package java的基本设计结构.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/19 20:34.
 * @Description java数组
 */

public class MyArray {
  public static void main(final String[] args) {
    // 命令行参数
    // java Message s
    // 得到参数 args [s]
    if (args.length == 0) {
      System.out.print('0');
    } else if (args.length == 1) {
      System.out.print(1);
    } else {
      System.out.print("i dont  know");
    }
  }
}
