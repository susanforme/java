# java

## 数值
```java
package java的基本设计结构;

import static java.lang.Math.*;
import static java.lang.System.out;
public class FirstSample {
  // 类常量,可以再这个类中多个方法使用
  public static final double MY_PI = 3.14;
  // 入口文件
  public static void main(final String[] args) {
    // 用final声明的是常量,使用全大写
    final var ONLY_A_NUMBER = 3;
    System.out.println(ONLY_A_NUMBER);
    // 整型
    final int vacationDays = 12;
    out.println("vacationDays:  " + vacationDays * vacationDays * MY_PI);
    // 求平方根
    final double MY_SQRT_VACATION_DAYS = sqrt(vacationDays);
    out.println(MY_SQRT_VACATION_DAYS);
    // 幂
    out.println(pow(vacationDays, 2));
    // 强制类型转换,相当于Math.floor()
    final double x = 10.6;
    final int nx = (int) x;
    out.println(nx == floor(x));
    out.println(nx);
  }
}

```

## 字符串
java没有内置的字符串类型,而是在标准Java类库中提供了预定义类,叫做String.Java字符串是由char值序列组成.

```java
public class MyString{
  public void main () {
    String e ="sadas123123";
    String s =e.substring(0,3); //切割
    //不可变字符串,字符串是不可变的,如果需要修改字符串e为只有字母
    e = e.substring(0,5);
    // 字符串,注意单引号,双引号区别
    final char foo = 'h';
    final String bar = "hello world";
    out.println(bar.substring(0, 2) + ",h: " + foo);
    // 检测字符串是否相等,使用equals比较而不是==
    out.println(bar.equals("hello world"));
    // 不要用==检测字符串是否相等,添加final后 == 能正确判断
    final String firstWord = "hello";
    out.println(firstWord == firstWord + "");
    // 不添加final 不能正确判断,java虚拟机在字符串会进行共享操作,指向同一个地址,但是再进行+操作后,subString后就不能比较
    String str2 = "";
    str2 = "hello";
    out.println(str2 == str2 + ""); // false
    out.println("hel" == str2.substring(0, 3)); // false
    //使用eval
    final String str = "hello";
    final String str2 = str.substring(0, 3);
    out.println(str2.equals("hel")); // true
    //码点与代码单元
    out.println(str.codePointAt(0)); // 返回指定索引位置的码点数量
    str.charAt(1); // 返回位置为n的代码单元
    out.println("offsetByCodePoints:  " + str.offsetByCodePoints(0, 2));
    // 遍历字符串
    final String str = "我有一头小毛驴,我从来也不骑.";
    for (char i = 0; i < str.length(); i++) {
      out.print(str.charAt(i));
    }
    final int[] codePoints = str.codePoints().toArray(); // 生成int值的流
    final String str2 = new String(codePoints, 0, codePoints.length); // 将码点数组转换为字符串
    out.println(codePoints.toString()); // [I@4411d970
    out.println(str2); // 我有一头小毛驴,我从来也不骑.
  }
}
```
