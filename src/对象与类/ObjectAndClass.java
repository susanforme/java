package 对象与类;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/26 20:18 .
 * @Description .
 */

import java.time.LocalDate;

public class ObjectAndClass {
  public static void main(final String[] args) {
    // 类库设计者决定将保存时间与给时间点命名分开,所以java类库包含了两个类,一个是用来表示时间点的Date类,另一个是表示熟悉的日历表示法的LocalDate类
    final LocalDate newYear = LocalDate.of(1992, 12, 31);
    final LocalDate otherYear = newYear.plusDays(1000); // 距离当今天数的指定日期
    // 会生成一个新的LocalDate数组
    System.out.print(otherYear); // 1995-09-27
    // 调用方法后这个对象的状态会被改变的方法称为更改器方法
    // 只访问对象而不修改对象的方法被称为访问器方法
  }
}
