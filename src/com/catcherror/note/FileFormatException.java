package com.catcherror.note;

import java.io.IOException;

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

  public static void main(final String[] args) {
    try {
      ErrorTest.readData(0);
    } catch (final FileFormatException e) {
      System.out.println("在" + e.toString() + "抛出了异常");
    }
  }
}
