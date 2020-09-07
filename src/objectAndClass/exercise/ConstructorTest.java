package objectAndClass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/9/7 21:12 .
 * @Description .
 */

public class ConstructorTest {
  private String name;
  private double salary;
  private int id;
  private static int nextId = 0;

  {
    this.id = nextId++;
  }

  public ConstructorTest() {
    this.name = "default";
    this.salary = 0;
  }

  public ConstructorTest(final double salary) {
    this();
    this.salary = salary;
  }

  public ConstructorTest(final String name) {
    this();
    this.name = name;
  }

  public String logAll() {
    return "id: " + this.id + ",name: " + this.name + ",salary: " + this.salary;
  }
}

class ConstructorTestOne {
  public static void main(final String[] args) {
    final ConstructorTest test = new ConstructorTest();
    final ConstructorTest test2 = new ConstructorTest("诚诚");
    System.out.println(test.logAll());
    System.out.println(test2.logAll());
  }
}
