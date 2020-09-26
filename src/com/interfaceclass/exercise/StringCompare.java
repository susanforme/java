package com.interfaceclass.exercise;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/26/13:17 .
 * @Description .
 */
public class StringCompare implements Comparator<String> {
  @Override
  public int compare(final String o1, final String o2) {
    if (o1.length() == o2.length()) {
      return 0;
    }
    return (o1.length() - o2.length()) > 0 ? 1 : -1;
  }
}

class StringCompareTest {
  public static void main(final String[] args) {
    final StringCompare stringCompare = new StringCompare();
    System.out.println(stringCompare.compare("test", "t"));
    final String[] friends = {"张飞", "我", "不灵不落我是个机器人"};
    Arrays.sort(friends, stringCompare);
    System.out.println(Arrays.toString(friends));
  }
}
