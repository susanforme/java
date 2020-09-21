package com.extendsclass.note;

import com.extendsclass.exercise.HashEmployee;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * @Author 不灵不落我是个机器人 .
 * @Email: rzc307853639@gmail.com .
 * @Date time: 2020/09/21/20:19 .
 * @Description .
 */
public class MyArrayList {
  public static void main(String args[]) {
    // 菱形语法
    ArrayList<HashEmployee> HashEmployeeList = new ArrayList<>();
    // 使用add方法添加到数组,如果空间用尽,那么数组列表会创建一个更大的数组,并且将所有的对象从较小数组拷贝到大数组,返回boolean
    HashEmployeeList.add(new HashEmployee("诚诚", 12, 12000));
    // 如果提前知道数组的大概存储范围,就可以在填充数组前调用ensureCapacity,这样就会提前分配一个个数为x的内部数组,
    // 这样一来,前100次add调用不会带来很大的内存开销
    HashEmployeeList.ensureCapacity(100);
    for (int x = 0; x < 100; x++) {
      HashEmployeeList.add(new HashEmployee("诚诚", x, 12000));
    }
    // size 返回数组的实际大小
    System.out.println(HashEmployeeList.size());
    // 一旦能够确定数组列表的大小保持恒定,不再发生变化,就可以调用trimToSize方法,这个方法将存储块的大小调整为保
    // 存当前元素所需的存储空间,垃圾回收期将会回收当前空间,一旦消减了数组列表的大小,添加新元素就需要再次画时间
    // 移动,所以一般是确定不再向数组添加元素才会调用该方法
    HashEmployeeList.trimToSize();
    // 访问数组元素,但是不能使用[]语法访问,因为这个类不是java语言的一部分而是,编写提供的一个工具类,只能使用set,get
    // set只能用于修改,添加只能用add
    HashEmployeeList.set(0, new HashEmployee("test", 1, 1));
    System.out.println(HashEmployeeList.get(0));
    // 下面方法可以一举两得,在创建完ArrayList后,直接使用toArray拷贝到一个数组中
    HashEmployee[] employees = new HashEmployee[HashEmployeeList.size()];
    HashEmployeeList.toArray(employees);
    System.out.println(Arrays.toString(employees));
    // 对于较小的数组使用add,remove没有大问题,但是存储的数据过多,又经常删除插入就应该使用链表

  }
}
