<!--
 * @Author: Spring Breeze
 * @Date: 2020-08-05 21:22:46
 * @FilePath: \myTestJavaApp\src\baseJava\baseJava.md
-->

# java

## 数值

```java
package baseJava;

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

java 没有内置的字符串类型,而是在标准 Java 类库中提供了预定义类,叫做 String.Java
字符串是由 char 值序列组成.

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
    //字符串转换为流
    final int[] codePoints = str.codePoints().toArray(); // 生成int值的流
    final String str2 = new String(codePoints, 0, codePoints.length); // 将码点数组转换为字符串
    out.println(codePoints.toString()); // [I@4411d970
    out.println(str2); // 我有一头小毛驴,我从来也不骑.

    /* 构建字符串,有时候需要较短字符串构建字符串,按键或者来自文件中的单词,采用字符串连接的效率较低,每次连接都会生成一个新的String对象,所以使用
    StringBuilder类,可以避免问题
    */
    final StringBuilder builder = new StringBuilder("12");
    builder.append("hello ");
    builder.append(" world");
    // 在需要使用字符串的时候调用toString方法
    final String completeStr = builder.toString();
    out.println(completeStr);
  }
}
```

## 输入输出

```java
package baseJava;

import java.util.Scanner;
import java.io.Console;
import java.util.Arrays;
import static java.lang.System.out;

/* @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/10 19:29.
 */

public class InAndOut {
  public static void main(final String[] args) {

// 输入,构造一个Scanner对象,并与标准输入流System.in关联
    final Scanner in = new Scanner(System.in);
    final String name = in.nextLine(); // 读取当前行
    final String firstName = in.next(); // 读取一个单词,空格分界
    final int age = in.nextInt(); // 读取一个整数,空格分界
    out.println("Hello, " + name + " or " + firstName + " you will be " + age); // 输出


    // 因为输入是可见的,所以Scanner类不适合从控制台读取密码,
    final Console cons = System.console(); // 不在命令行中调用为null
    if (cons != null) {
      final String username = cons.readLine("User name: ");
      final char[] passwd = cons.readPassword("password: ");
      System.out.println(username + Arrays.toString(passwd));
    } else {
      System.out.println("请在命令行中调用");
    }

    // 格式化输出
    final double x = 10000.0 / 3.0;
    // 8个字符宽度和小数点后2位
    System.out.printf("%8.2f\n", x);
    // 替换字符
    System.out.printf("hello,%s,Next year you will be %d", "rzc", 20);

    // 文件的读取
    try {
    //扫描器
      final Scanner in =
          // 以项目根目录为路径
          new Scanner(Paths.get("./src/baseJava/baseJava.md"), StandardCharsets.UTF_8);
      for (int i = 0; i < 100; i++) {
        //in.next()像使用System.in一样读取
        System.out.println(in.next());
      }
    } catch (final IOException e) {
      e.printStackTrace();
    }

    // 文件的写入
    try {
      // 想对路径报错文件不存在,文件名则会在根目录创建
      final PrintWriter out = new PrintWriter("com/basejava/hello.txt", StandardCharsets.UTF_8);
      // 像使用System.out一样使用
      out.println("wo ai ni");
      out.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }
}

```

## 控制流程

与任何程序设计语言一样， Java 使用条件语句和循环结构确定控制流程。本节先讨论条件
语句， 然后讨论循环语句，最后介绍看似有些笨重的 switch 语句，当需要对某个表达式
的多个值进行检测时， 可以使用 switch 语句。

```java
package baseJava;
/*
 * @Author susan Email: rzc307853639@gmail.com.
 * @Date time: 2020/8/11 21:01.
 */

public class controlFlow {
  public static void main(final String[] args) {
    //     块作用域
    //     如下正确
    int n;
    {
      int k;
      //int n; 错误,不能在嵌套的作用域声明
    }
    // 条件语句
    final double a = Math.random();
    if (a > 0.5) {
      System.out.println(true);
    } else {
      System.out.println(false);
    }
    // 循环
    int count = 0;
    while (Math.random() > 0.5) {
      System.out.println(++count);
      }
    // 确定循环
    for (int i = 1; i < 10; i++) {
      System.out.println(i);
     }
    }
      //浮点上下文中的整数除法,两个整数相除，结果必定是整数，
	int a =1;
  int b=2;
  double c = a/b; // 0.0
    // 多重选择switch
    //  System.out.println("write your number");
   final Scanner scan = new Scanner(System.in);
   final int num = scan.nextInt();
        switch (num){
          case 1:
            {
              System.out.println(1);
              System.out.println("hi 1");
              break;
            }
          case 2:
            {
              System.out.println(2);
              System.out.print("hi 2");
              break;
            }
          default:
            {
              System.out.println("this is default");
              break;
            }
        }
  }

```

## 数组

```java

public class MyArray {
  public static void main(final String[] args) {
    // 数组是用来存储同一类型值的集合,通过下标可以访问数组中的每一个值,类似ts的元组,定义长度就不能传递默认值,
    final int[] a = new int[100] ;
 for (int i = 0; i < a.length; i++) {
      a[i] = i;
     }
    System.out.println(Arrays.toString(a));

    // for each 循环
    final int[] a = new int[100];
    for (int i = 0; i < a.length; i++) {
      a[i] = i;
    }
    for (final int element : a) {
      System.out.println(element);
    }

    // 数组拷贝,在拷贝的时候是拷贝的指针,指向引用的同一个数组
    final int[] a = new int[] {1};
    final int[] b = a;
    System.out.println(Arrays.toString(a));//1
    a[0] = 3;
    System.out.println(Arrays.toString(b)); //3
    System.out.println(a == b); //true

    // 数组拷贝,在拷贝的时候是拷贝的指针,指向引用的同一个数组,    copyOf为深拷贝
    final int[] a = new int[] {1};
    final int[] b = Arrays.copyOf(a, a.length * 2); // 第二个参数是数组长度,如果数组是数值,
    // 多余的参数被赋值为0,布尔值则为false,小于长度则为截取的长度
    System.out.println(Arrays.toString(a)); // 1
    a[0] = 3;
    System.out.println(Arrays.toString(b)); // 1
    System.out.println(a == b); // false

    // 命令行参数
    // java Message s
    // 得到参数 args [s]
    if (args.length == 0) {
      System.out.print('0');
    } else if (args.length == 1) {
      System.out.print(1);
    } else {
      System.out.print("i dont  know");
    }

    // 数组排序
    final int[] a = new int[] {1, 10, 2, 3};

    // 无返回值,在原数组上改变
    Arrays.sort(a);
    System.out.println(Arrays.toString(a)); // 1 2 3 10

    // 多维数组
    final double[][] balances = new double[3][3];
    final double[][] magics = new double[][] {{1, 2, 3}, {1, 2, 3}};
    for (int i = 0; i < balances.length; i++) {
      for (int j = 0; j < balances[i].length; j++) {
        balances[i][j] = Math.random();
      }
    }
    System.out.println(Arrays.deepToString(balances));
    //    System.out.println(Arrays.deepToString(magics));
    for (final double[] i : magics) {
      for (final double j : i) {
        System.out.print(j + ", ");
      }
    }

    // 不规则数组
    final double[][] balances = new double[10][6];
    for (int i = 0; i < balances.length; i++) {
      for (int j = 0; j < balances[i].length; j++) {
        balances[i][j] = Math.random() * 100;
      }
    }
    for (final double[] k : balances) {
      for (final double j : k) {
        System.out.printf("%10.2f", j);
      }
      System.out.print("\n");
    }
  }
}
```
