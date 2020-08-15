package java的基本设计结构.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/14 20:59.
 * @Description 大数.
 */

import java.math.BigInteger;

public class BigNumber {
  /* 如果基本的整数和浮点数不能满足需求,那么就可以使用java.math包中的类,BigInteger
   * BigDecimal,BigInteger任意长度的整数运算,BigDecimal 任意长度的浮点数运算
   */
  public static void main(final String[] args) {
    final BigInteger a = BigInteger.valueOf(100);
    final BigInteger b = BigInteger.valueOf(100);
    // 大数不能使用+ * 运算
    final BigInteger c = a.add(b);
    final BigInteger d = a.multiply(b);
    System.out.println("this is c: " + c + ",this is d: " + d);
  }
}
