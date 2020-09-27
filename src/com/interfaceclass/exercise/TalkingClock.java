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
}

class TalkingTest {
  public static void main(final String[] args) {
    new TalkingClock(1000).start(true);
    // 必须要有如下代码才能保持代码运行
    JOptionPane.showMessageDialog(null, "关闭?");
    System.exit(0);
  }
}
