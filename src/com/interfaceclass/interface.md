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