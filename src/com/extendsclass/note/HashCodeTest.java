package com.extendsclass.note;

import com.extendsclass.exercise.HashEmployee;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/20/17:58 .
 * @Description .
 */
public class HashCodeTest {
  public static void main(String[] args) {
    int hashCode = "我爱你".hashCode();
    System.out.println(hashCode);
    System.out.println("------------------");
    HashEmployee hashEmployee = new HashEmployee("诚诚", 11, 123);
    HashEmployee hashTwo = new HashEmployee("诚诚", 2, 123);
    System.out.println(
        hashTwo.equals(hashEmployee) + "--" + hashEmployee.hashCode() + "---" + hashTwo.hashCode());
  }
}
