package objectAndClass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/9/2 20:14 .
 * @Description .
 */

public class StaticTest {
  public static void main(final String[] args) {
    final SimpleEmployee[] employees = new SimpleEmployee[3];
    employees[0] = new SimpleEmployee("诚诚", 12);
    employees[1] = new SimpleEmployee("🌸", 13);
    employees[2] = new SimpleEmployee("偶然", 10);
    for (final SimpleEmployee e : employees) {
      System.out.println(SimpleEmployee.getNextId());
      System.out.println(e.logMsg());
    }
  }
}
