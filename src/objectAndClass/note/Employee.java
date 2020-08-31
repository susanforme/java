package objectAndClass.note;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/31 20:57 .
 * @Description .
 */

public class Employee {
  private final String name;
  private final int age;
  private final double salary;

  public Employee(final String n, final int a, final double s) {
    name = n;
    age = a;
    salary = s;
  }
  /** 输出所有信息 */
  public String logAllMsg() {
    return "员工" + name + "年龄" + age + "的薪水是" + salary;
  }
  /** 年龄 */
  public int getAge() {
    return age;
  }
}
