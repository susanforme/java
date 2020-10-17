package com.catcherror.exercise;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/10/17/3:09 PM .
 * @Description .
 */
public class StackTraceTest {
  /** 递归 */
  public static int factorial(final int n) {
    final Throwable t = new Throwable();
    final StringWriter out = new StringWriter();
    t.printStackTrace(new PrintWriter(out));
    System.out.println(out.toString());
    if (n <= 1) {
      return n;
    } else {
      return n * factorial(n - 1);
    }
  }

  public static void main(final String[] args) {
    try (final Scanner s = new Scanner(System.in)) {
      System.out.println("输入: ");
      System.out.println(factorial(s.nextInt()));
    }
  }
}
