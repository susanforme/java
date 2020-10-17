package com.catcherror.note;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/10/09/8:20 PM .
 * @Description .
 */
public class FileFormatException extends IOException {
  public FileFormatException() {}

  public FileFormatException(final String a) {
    super(a);
  }
}

class ErrorTest {
  public static String readData(final int length) throws FileFormatException {
    if (length < 1) {
      throw new FileFormatException();
    }
    System.out.println("congratulations!");
    return "congratulations!";
  }

  public static int parseInt(final String s) {
    try {
      return Integer.parseInt(s);
    } catch (final NumberFormatException error) {
      System.out.println(error.getMessage());
      return 0;
    } finally {
      System.out.println("执行结束了");
    }
  }

  public static void readDataWithAutoClose() {
    try (final Scanner in =
        new Scanner(
            new FileInputStream("C:\\Users\\不灵不落我是个机器人\\Desktop\\ok\\学习\\python过程.txt"),
            String.valueOf(StandardCharsets.UTF_8))) {
      while (in.hasNext()) {
        System.out.println(in.next());
      }
      System.out.println("try语句执行完成,没有异常哦");
    } catch (final FileNotFoundException error) {
      System.out.println(error.getMessage());
      System.out.println("文件没找到哦");
    }
  }

  public static void main(final String[] args) {
    ErrorTest.readDataWithAutoClose();
  }
}
