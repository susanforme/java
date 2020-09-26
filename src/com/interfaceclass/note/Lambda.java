package com.interfaceclass.note;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/26/16:46 .
 * @Description .
 */
public class Lambda {
  public static void main(final String[] args) {
    final String[] strings = {"tom", "jerry", "mark"};
    Arrays.sort(strings, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(strings));
    Lambda.requestMsg("123", 1000);
  }

  public static void requestMsg(final String text, final int delay) {
    final ActionListener listener =
        event -> {
          System.out.println(text);
          Toolkit.getDefaultToolkit().beep();
        };
    new Timer(delay, listener).start();
  }
}
