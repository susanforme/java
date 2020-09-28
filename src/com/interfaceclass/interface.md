# 接口,lambda 表达式与内部类

## 接口

```java

package com.interfaceclass.note;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/23/20:16 .
 * @Description .
 */

import com.extendsclass.exercise.HashEmployee;

import java.util.Arrays;

public interface Compare<T> {
  // 自动是public
  public int compareTo(T o);
}

class EmployeeWithInterface extends HashEmployee implements Comparable<EmployeeWithInterface> {

  public EmployeeWithInterface(String n, int a, double s) {
    super(n, a, s);
  }

  /**
   * @param other 另一个对象
   * @return 返回整数
   */
  public int compareTo(EmployeeWithInterface other) {
    return Integer.compare(super.getAge(), other.getAge());
  }
}

class InterfaceTest {
  public static void main(String[] args) {
    EmployeeWithInterface e = new EmployeeWithInterface("cheng", 12, 12);
    EmployeeWithInterface e2 = new EmployeeWithInterface("two", 13, 123);
    EmployeeWithInterface e3 = new EmployeeWithInterface("one", 11, 11);
    EmployeeWithInterface[] employeeWithInterfaces = {e, e2, e3};
    System.out.println(e.compareTo(e2));
    Arrays.sort(employeeWithInterfaces);
    System.out.println(Arrays.toString(employeeWithInterfaces));
  }
}

```

### 接口的属性

1. 接口不能实例化
2. 能用来声明变量
3. 接口变量必须引用实现了这个接口的类对象
4. 可以使用instanceof检测是否实现了特定的接口
5. 和类一样也能扩展,可以和一个通用性较高的接口扩展到专业性较高的接口
6. 不能包含实例字段,但是能包含常量

```java
package com.interfaceclass.note;

import com.sun.istack.internal.NotNull;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/23/21:24 .
 * @Description .
 */
public interface Person {
  @NotNull
  String changeName(String x);
}

interface Employee extends Person {

  void raiseSalary(double salary);
  // 自动设置为public static
  double ALLOWANCE = 30.2;
}

class PersonInterfaceTest implements Person {
  @Override
  public String changeName(final String x) {
    return "test" + x;
  }
}

class EmployeeInterfaceTest implements Employee {
  @Override
  public void raiseSalary(final double salary) {}

  @Override
  public String changeName(final String x) {
    return "t" + x;
  }
}

```

1. 每个类只能有一个超类,但是可以有多个接口
2. 如果希望自己的类拥有克隆能力,那么只需要继承两个接口就可以

```
class Employee implements Cloneable,Comparable
```

### 接口与抽象类

为什么需要接口

```java
abstract class Comparable{
    public abstract int compareTo();
}
interface Comparable{
    int compareTo();
}
```

那是因为,对象只能有一个超类,但是可以继承多个接口

### 默认方法

```java
interface Default {
  int size();
  // 默认方法,可以不用重写,默认继承该方法
  default boolean isEmpty() {
    return size() == 0;
  }

  default String logDefault() {
    return "default";
  }
}

class DefaultTest implements Default {
  @Override
  public int size() {
    return 0;
  }
}
```

### 默认方法冲突

如果接口将一个方法定义为默认方法,然后又在超类中定义同样的方法,

1. 超类中优先
2. 接口冲突,如果继承了两个接口的同时,两个接口提供了相同的默认方法,那么就必须在类中覆盖方法

```java
interface Default {
  default String logDefault() {
    return "default";
  }
}

interface Named {
  default String logDefault() {
    return "named";
  }
}

class DefaultTest implements Default, Named {
  @Override
  public int size() {
    return 0;
  }

  @Override
  public String logDefault() {
    return Default.super.logDefault();
  }
}
```

3. 在Named接口没有为getName提供默认接口,java同样会报错

```java
interface Named {
   String logDefault();
}
```

**类优先** 在同等条件下,类中的方法属性总是优先的

### 接口与回调

```java
package com.interfaceclass.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/24/21:26 .
 * @Description 定时器
 */

// interface ActionListener {
//  // 当到达指定的时间间隔,定时器就调用actionPerformed方法
//  void actionPerformed(ActionEvent event);
// }

public class TimePrinter implements ActionListener {
  public void actionPerformed(final ActionEvent event) {
    System.out.println("the time is " + Instant.ofEpochMilli(event.getWhen()));
    // 工具箱中的方法,作用是响一声
    Toolkit.getDefaultToolkit().beep();
  }
}

class Test {
  public static void main(final String[] args) {
    final TimePrinter timePrinter = new TimePrinter();
    // 构造一个定时器,每隔delay秒,通知listener一次
    final Timer timer = new Timer(1000, timePrinter);
    // 启动定时器,启动就将会调用监听器的actionPerformed
    timer.start();
    // 显示一个包含提示消息和ok按钮的对话框,这个对话框位于parent的中央,为null则在屏幕中央
    JOptionPane.showMessageDialog(null, "关闭程序?");
    System.exit(0);
  }
}

```

### Comparator接口

String.compareTo可以按照字典顺序比较字符串

如果需要按照字符串长度比较则需要Comparator接口的类的实例

```java
package com.interfaceclass.exercise;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/26/13:17 .
 * @Description .
 */
public class StringCompare implements Comparator<String> {
  @Override
  public int compare(final String o1, final String o2) {
    if (o1.length() == o2.length()) {
      return 0;
    }
    return (o1.length() - o2.length()) > 0 ? 1 : -1;
  }
}

class StringCompareTest {
  public static void main(final String[] args) {
    final StringCompare stringCompare = new StringCompare();
    System.out.println(stringCompare.compare("test", "t"));
    final String[] friends = {"张飞", "我", "不灵不落我是个机器人"};
    Arrays.sort(friends, stringCompare);
    System.out.println(Arrays.toString(friends));
  }
}

```

### 对象克隆

```java
package com.interfaceclass.exercise;

import com.extendsclass.exercise.HashEmployee;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/26/13:32 .
 * @Description .
 */
public class CloneableTest extends HashEmployee implements Cloneable {
  public CloneableTest(final String n, final int a, final double s) {
    super(n, a, s);
  }

  @Override
  public CloneableTest clone() throws CloneNotSupportedException {
    return (CloneableTest) super.clone();
  }
}

class CloneTest {
  public static void main(final String[] args) throws CloneNotSupportedException {
    final CloneableTest cloneableTest = new CloneableTest("诚诚", 12, 123.12);
    /* final HashEmployee hashEmployee = new HashEmployee("诚诚", 123, 123);
     * 对象不能直接调用clone,数组可以
     * hashEmployee.clone(); 报错
     */
    final CloneableTest test = cloneableTest;
    System.out.println(test == cloneableTest); // true
    System.out.println(cloneableTest.clone() == cloneableTest); // false
  }
}

```

## lambda表达式

lambda表达式是一个可传递的代码块,可以在以后执行一次或者多次

lambda表达式必须在每一个分支都返回值,也就是说必须有返回值

```java
package com.interfaceclass.note;

import java.util.Arrays;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/26/16:46 .
 * @Description .
 */
public class Lambda {
  public static void main(final String[] args) {
    final String[] friends = {"Tom", "Jerry", "Mark"};
    System.out.println(Arrays.toString(friends));
    Arrays.sort(friends);
    System.out.println(Arrays.toString(friends));
    Arrays.sort(friends, (first, second) -> first.length() - second.length());
    System.out.println(Arrays.toString(friends));
  }
}

```

### 函数式接口

对于只有一个抽象方法的接口,需要这种接口的时候,就可以提供一个lambda表达式,这种接口称为函数式接口

例如,Arrays.sort方法他的第二个参数需要一个实现了Comparator的实例,Comparator就是只有一个方法的接口,所以可以提供一个lambda表达式

```java
Arrays.sort(friedns,(first,second)->first.length()-second.length());
```

**在底层,Arrays.sort方法会接受实现了Comparator\<String> 的一个类的对象,在这个对象上调用compare方法,执行这个lambda体**

```java
/** 定时触发器,简化版*/
class SimplePrinter {
  public static void main(final String[] args) {
    final Timer timer =
        new Timer(
            1000,
            (event) -> {
              System.out.println("the time is " + Instant.ofEpochMilli(event.getWhen()));
              Toolkit.getDefaultToolkit().beep();
            });
    timer.start();
    JOptionPane.showMessageDialog(null, "关闭程序?");
    System.exit(0);
  }
}

```

### 方法引用

```java
public class Lambda {
  public static void main(final String[] args) {
      // 等同于 event ->System.out.println(event);
    final Timer timer = new Timer(1000, System.out::println);
    timer.start();
    final String[] strings = {"tom", "jerry", "mark"};
    Arrays.sort(strings, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(strings));
  }
}

```

格式为

1. object::method
2. Class:instancemethod
3. Class:staticMethod

等同于,对象调用方法,但是需要注意的是,只能有一个方法调用不能有其他操作,例如如下便不能以方法引用的形式

```java
s -> s.length() ==0;
```

调用了length,然后进行了比较

### 变量作用域

lambda表达式可以捕获外部作用域的变量,在java中,确保所捕获的值是明确而不能改变的

也就是说lambda中引用的外部变量,必须是final

## 内部类

1. 内部类是定义在一个类中的类
2. 内部类可以对同一个包中的其他类隐藏
3. 内部类方法可以访问定义这个类的作用域中的数据,包括私有数据
4. 内部类中的所有字段都必须是final,并初始化为一个编译时常量
5. 内部类不能有static方法

```java
package com.interfaceclass.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/27/20:24 .
 * @Description .
 */
public class TalkingClock {
  private final int interval;
  private final boolean isBeep;

  public TalkingClock(final int interval, final boolean isBeep) {
    this.interval = interval;
    this.isBeep = isBeep;
  }

  public void start() {
    final Timer timer = new Timer(this.interval, new TimePrinter());
    timer.start();
  }

  class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent e) {
      System.out.println("the time is " + Instant.ofEpochMilli(e.getWhen()));
      if (TalkingClock.this.isBeep) {
        Toolkit.getDefaultToolkit().beep();
      }
    }
  }
}

class TalkingTest {
  public static void main(final String[] args) {
    new TalkingClock(1000, true).start();
    // 必须要有如下代码才能保持代码运行
    JOptionPane.showMessageDialog(null, "关闭?");
    System.exit(0);
  }
}

```

实际上在编译器内部,会被转换为两个类文件

### 局部内部类

1. 声明局部类的嘶吼不能有修饰符,局部类的作用域只有在声明的区域有效

```java
package com.interfaceclass.exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/27/20:24 .
 * @Description .
 */
public class TalkingClock {
  private final int interval;

  public TalkingClock(final int interval) {
    this.interval = interval;
  }

  public void start(final boolean isBeep) {
    class TimePrinter implements ActionListener {
      @Override
      public void actionPerformed(final ActionEvent e) {
        System.out.println("the time is " + Instant.ofEpochMilli(e.getWhen()));
        if (isBeep) {
          Toolkit.getDefaultToolkit().beep();
        }
      }
    }
    final Timer timer = new Timer(this.interval, new TimePrinter());
    timer.start();
  }
}

class TalkingTest {
  public static void main(final String[] args) {
    new TalkingClock(1000).start(true);
    // 必须要有如下代码才能保持代码运行
    JOptionPane.showMessageDialog(null, "关闭?");
    System.exit(0);
  }
}

```

### 匿名内部类

```java
  public void start(final boolean isBeep) {
    final ActionListener listener =
        new ActionListener() {
          @Override
          public void actionPerformed(final ActionEvent e) {
            System.out.println("the time is " + Instant.ofEpochMilli(e.getWhen()));
            if (isBeep) {
              Toolkit.getDefaultToolkit().beep();
            }
          }
        };
    final Timer timer = new Timer(this.interval, listener);
    timer.start();
  }
```

语法如下

SuperType可以是类可以是接口

```
new SuperType(){

}
```

### 双括号初始化

1. 第一个大括号生成的是ArrayList的一个匿名子类

2. 内部括号则是一个对象初始化块

```java
package com.interfaceclass.note;

import java.util.ArrayList;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/27/21:11 .
 * @Description .
 */
public class DoubleBrace {
  public static void main(final String[] args) {
    final ArrayList<String> friends = new ArrayList<>();
    friends.add("Tom");
    friends.add("jerry");
    System.out.println(friends.toString());
    final ArrayList<String> myFriends =
        new ArrayList<String>() {
          {
            add("Tom");
            add("jerry");
          }
        };
    System.out.println(myFriends.toString());
  }
}

```

### 静态内部类

```java
package com.interfaceclass.exercise;

import java.util.Arrays;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/28/20:51 .
 * @Description .
 */
public class ArrayAlg {
  public static class Pair {
    private final double first;
    private final double second;

    public Pair(final double first, final double second) {
      this.first = first;
      this.second = second;
    }

    public double min() {
      return this.first;
    }

    public double max() {
      return this.second;
    }
  }

  public static Pair minMax(final double... values) {
    final double[] vs = values.clone();
    Arrays.sort(vs);
    return new Pair(vs[0], vs[vs.length - 1]);
  }
}

class ArrayAlgTest {
  public static void main(final String[] args) {
    final ArrayAlg.Pair result = ArrayAlg.minMax(new double[] {1.2, 1.3, 1.0});
    System.out.println("min " + result.min() + " max: " + result.max());
  }
}

```

