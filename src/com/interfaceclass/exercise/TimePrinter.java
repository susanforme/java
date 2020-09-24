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
