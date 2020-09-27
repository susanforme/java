package com.interfaceclass.note;

import java.util.ArrayList;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/27/21:11 .
 * @Description .
 */
public class DoubleBrace {
  public static void main(final String[] args) {
    final ArrayList<String> friends = new ArrayList<>();
    friends.add("Tom");
    friends.add("jerry");
    System.out.println(friends.toString());
    final ArrayList<String> myFriends =
        new ArrayList<String>() {
          {
            add("Tom");
            add("jerry");
          }
        };
    System.out.println(myFriends.toString());
  }
}
