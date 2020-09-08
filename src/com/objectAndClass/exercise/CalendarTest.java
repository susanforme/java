package com.objectAndClass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/8/31 20:31 .
 * @Description 输出今天的时间
 */

import java.util.Calendar;

public class CalendarTest {
  public static void main(final String[] args) {
    final Calendar calendar = Calendar.getInstance();
    final int years = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int hours = calendar.get(Calendar.HOUR_OF_DAY);
    System.out.printf("%s年-%s月-%s号-%s时", years, month, day, hours);
  }
}
