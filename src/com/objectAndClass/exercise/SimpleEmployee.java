package com.objectAndClass.exercise;
/*
 * @Author susan .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/9/2 20:15 .
 * @Description .
 */

public class SimpleEmployee {
  private int id;
  private static int nextId = 0;
  private String name;
  private double salary;

  public SimpleEmployee(final String n, final double s) {
    this.id = nextId;
    this.name = n;
    this.salary = s;
    nextId++;
  }

  public static int getNextId() {
    return nextId;
  }

  public String logMsg() {
    return this.name + this.salary;
  }
}
