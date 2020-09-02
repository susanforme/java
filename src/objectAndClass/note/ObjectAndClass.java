package objectAndClass.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/26 20:18 .
 * @Description .
 */

public class ObjectAndClass {
  public static void main(final String[] args) {
    final Employee e1 = new Employee("s", 12, 123);
    final Employee e2 = new Employee("baseJava", 11, 12323);
    swap(e1, e2);
    System.out.println(e1.logAllMsg());
  }

  public static void swap(Employee x, Employee y) {
    final Employee e = x;
    x = y;
    y = e;
  }
}
