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

## 泛型数组列表

1. ArrayList类似于数组,但在添加或删除元素,它能自动调整数组容量,而不需要编写额外代码,
2. ArrayList是一个有类型参数的泛型类,为了指定数组列表保存的元素对象的类型,需要使用一对尖括号将类名括起来追加到ArrayList后面,例如 ArrayList**\<Employee>**  

```java
package com.extendsclass.note;

import com.extendsclass.exercise.HashEmployee;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/21/20:19 .
 * @Description .
 */
public class MyArrayList {
  public static void main(String args[]) {
    // 菱形语法
    ArrayList<HashEmployee> HashEmployeeList = new ArrayList<>();
    // 使用add方法添加到数组,如果空间用尽,那么数组列表会创建一个更大的数组,并且将所有的对象从较小数组拷贝到大数组,返回boolean
    HashEmployeeList.add(new HashEmployee("诚诚", 12, 12000));
    // 如果提前知道数组的大概存储范围,就可以在填充数组前调用ensureCapacity,这样就会提前分配一个个数为x的内部数组,
    // 这样一来,前100次add调用不会带来很大的内存开销
    HashEmployeeList.ensureCapacity(100);
    for (int x = 0; x < 100; x++) {
      HashEmployeeList.add(new HashEmployee("诚诚", x, 12000));
    }
    // size 返回数组的实际大小
    System.out.println(HashEmployeeList.size());
    // 一旦能够确定数组列表的大小保持恒定,不再发生变化,就可以调用trimToSize方法,这个方法将存储块的大小调整为保
    // 存当前元素所需的存储空间,垃圾回收期将会回收当前空间,一旦消减了数组列表的大小,添加新元素就需要再次画时间
    // 移动,所以一般是确定不再向数组添加元素才会调用该方法
    HashEmployeeList.trimToSize();
    // 访问数组元素,但是不能使用[]语法访问,因为这个类不是java语言的一部分而是,编写提供的一个工具类,只能使用set,get
    // set只能用于修改,添加只能用add
    HashEmployeeList.set(0, new HashEmployee("test", 1, 1));
    System.out.println(HashEmployeeList.get(0));
    // 下面方法可以一举两得,在创建完ArrayList后,直接使用toArray拷贝到一个数组中
    HashEmployee[] employees = new HashEmployee[HashEmployeeList.size()];
    HashEmployeeList.toArray(employees);
    System.out.println(Arrays.toString(employees));
    // 对于较小的数组使用add,remove没有大问题,但是存储的数据过多,又经常删除插入就应该使用链表
  }
}

```

## 对象包装器与自动装箱

1. 包装器类有显而易见的名字
2. Integer Float Long Double Short Byte Character Boolean(包装器类是不可变的)
3. 一旦构造了包装器,其中的值就不允许改变,同时包装器类还是final不允许构建子类

```java
package com.extendsclass.note;

import java.util.ArrayList;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/21/21:15 .
 * @Description .
 */
public class Boxing {
  public static void main(String[] args) {
    // 所以定义一个整型数组列表,但是菱形语法中只能传递类,而不能是基本数据类型如int
    ArrayList<Integer> someNum = new ArrayList<>();
    // 在这里会触发一个装箱操作
    someNum.add(1);
    // 等同于,称之为自动装箱
    someNum.add(Integer.valueOf(2));
    // 相反的是,给定一个int,会自动转为Integer
    int x = someNum.get(1);
    int y = someNum.get(1).intValue();
    // 但是==检测的包装器对象的内存位置
    Integer a = 1000;
    Integer b = 1000;
    // false,如果a,b小于100就会成功
    System.out.println(a == b);
    System.out.println(Boxing.max(new double[] {1, 2, 3}));
  }

  public static double max(double... x) {
    if (x.length == 0) {
      throw new Error("不要传空数组啊");
    }
    double max = x[0];
    for (double v : x) {
      if (v > max) {
        max = v;
      }
    }
    return max;
  }
}

```

## 参数数量可变的方法

1. 也被称为变参方法例如 System.out.println("%d",n) System.out.println("%d",n,"widgets)

2. 调用的不同的方法,但是传入了不同数量的参数

```java
  public static double max(double... x) {
    if (x.length == 0) {
      throw new Error("不要传空数组啊");
    }
    double max = x[0];
    for (double v : x) {
      if (v > max) {
        max = v;
      }
    }
    return max;
  }
```

## 枚举类

