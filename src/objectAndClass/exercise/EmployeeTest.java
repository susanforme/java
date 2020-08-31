package objectAndClass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/31 21:25 .
 * @Description .
 */

import objectAndClass.note.Employee;

public class EmployeeTest {
  public static void main(final String[] args) {
    final Employee[] employees = new Employee[3];
    for (int i = 0; i < employees.length; i++) {
      employees[i] = new Employee("诚诚", (int) Math.round(Math.random() * 20), 3000);
    }
    for (final Employee e : employees) {
      System.out.println(e.logAllMsg());
    }
  }
}
