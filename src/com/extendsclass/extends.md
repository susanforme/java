# 继承

## 阻止继承

```java
// 使用final修饰符的类,不能被扩展
public final class Test extends ManageTest{
    
}
```

## 抽象类

1. 员工是一个人,学生也是一个人,所以人Person是员工或学生的抽象,但实际上只会把这个类用来派生其他类,而不是实例化需要的类
2. 抽象类中一般不能包含具体方法的实现

```java
package com.extendsclass.exercise;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/19/16:04 .
 * @Description 一个抽象类
 */
public abstract class Person {
  private String name;
  private int age;
  private String sex;

  public Person(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  public String getName() {
    return this.name;
  }

  public abstract String getDescription();
}

class ChengCheng extends Person {
  private String major;

  public ChengCheng(String name, int age, String sex, String major) {
    super(name, age, sex);
    this.major = major;
  }

  public String getDescription() {
    return this.getName() + " student major in" + this.major;
  }
}

```

### protected

对本包和所有子类可见,一般用来修饰方法

## Object

所有类的超类

### Object类型的变量

在java中只有基本数据类型不是对象,例如数值,字符,布尔类型都不是对象

### 相等测试与变量

实现equal的常见错误

```java
package com.extendsclass.exercise;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/19/16:43 .
 * @Description .
 */
public class EmployeeEquals {
  private String name;

  public EmployeeEquals(String name) {
    this.name = name;
  }

  /* 声明的显示参数是Employee,并没有覆盖Object类的equals方法,因为签名不同,方法重载了
   * @Override没什么实际作用,写上可以当注释用,方便阅读
   * 编译器可以验证是否是父类中所有的方法,没有则报错
   */
  @Override
  public boolean equals(Object other) {
    return other != null
        && getClass() == other.getClass()
        && getName() == ((EmployeeEquals) other).getName();
  }

  public String getName() {
    return this.name;
  }
}

class EmployeeEqualsTest {
  public static void main(String[] args) {
    EmployeeEquals employee = new EmployeeEquals("诚诚");
    EmployeeEquals employee2 = new EmployeeEquals("诚诚");
    System.out.println(employee.equals(employee2));
  }
}

```

### hashCode

1. 散列码是由对象导出的一个整型值,散列码是没有规律的,如果x和y是两个不同的对象,那么x.hashCode 和y.hashCode基本上不会相同
2. 如果重新定义了equals方法,那么一般需要重新定义hashCode方法

### toString

toString会返回一个表示对象值

```java
package com.extendsclass.exercise;

import com.objectandclass.note.Employee;

import java.util.Objects;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/20/18:03 .
 * @Description .
 */
public class HashEmployee extends Employee {
  public HashEmployee(String n, int a, double s) {
    super(n, a, s);
  }

  @Override
  public boolean equals(Employee other) {
    return Objects.equals(this.getName(), other.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.getName());
  }

  /** 绝大多数的toString都遵循方法,类的名字,随后是一段括号括起来的字段值 */
  @Override
  public String toString() {
    // super.toString()
    return getClass().getName()
        + "[name="
        + super.getName()
        + ",age="
        + super.getAge()
        + ",salary="
        + super.getSalary()
        + "]";
  }
}

class HashEmployeeTest {
  public static void main(String[] args) {
    HashEmployee hash = new HashEmployee("诚诚", 12, 10000.01);
    // 只要对象与一个字符串通过操作符+,连接起来,java编译器就会自动调用toString方法,来获得字符串描述
    // 在println中传入对象,也会调用对象的toString方法,
    System.out.println(hash);
    System.out.println("-----------------");
    // java.io.PrintStream@1b6d3586 对象的类名和散列码
    System.out.println(System.out);
    int[] luckyNumber = {1, 2};
    // s:[I@4554617c 前缀i表明是一个整型数组跟着hash值,补救方法是调用Array.toString
    System.out.println("s:" + luckyNumber);
  }
}

```

