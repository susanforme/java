package com.catcherror.note;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/10/20/8:07 PM .
 * @Description .
 */
public class Note {
  public static void main(final String[] args) {
    final Scanner scan = new Scanner(System.in);
    System.out.println("是否启用日志");
    final int isTurnOnLog = scan.nextInt();
    if (isTurnOnLog > 10) {
      Logger.getGlobal().setLevel(Level.OFF);
    }
    Logger.getGlobal().info("日志输出");
  }
}
