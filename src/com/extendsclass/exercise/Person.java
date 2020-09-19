package com.extendsclass.exercise;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/19/16:04 .
 * @Description 一个抽象类
 */
public abstract class Person {
  private String name;
  private int age;
  private String sex;

  public Person(String name, int age, String sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  public String getName() {
    return this.name;
  }

  public abstract String getDescription();
}

class ChengCheng extends Person {
  private String major;

  public ChengCheng(String name, int age, String sex, String major) {
    super(name, age, sex);
    this.major = major;
  }

  public String getDescription() {
    return this.getName() + " student major in" + this.major;
  }
}
