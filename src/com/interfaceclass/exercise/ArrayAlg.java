package com.interfaceclass.exercise;

import java.util.Arrays;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/28/20:51 .
 * @Description .
 */
public class ArrayAlg {
  public static class Pair {
    private final double first;
    private final double second;

    public Pair(final double first, final double second) {
      this.first = first;
      this.second = second;
    }

    public double min() {
      return this.first;
    }

    public double max() {
      return this.second;
    }
  }

  public static Pair minMax(final double... values) {
    final double[] vs = values.clone();
    Arrays.sort(vs);
    return new Pair(vs[0], vs[vs.length - 1]);
  }
}

class ArrayAlgTest {
  public static void main(final String[] args) {
    final ArrayAlg.Pair result = ArrayAlg.minMax(new double[] {1.2, 1.3, 1.0});
    System.out.println("min " + result.min() + " max: " + result.max());
  }
}
