package com.aote.doubleLinedList;

/**
 * 双向链表对象
 */
public class MyDoubleLinked {

    public int no;
    public MyDoubleLinked pre;
    public MyDoubleLinked next;
    public String name;

    public MyDoubleLinked() {
    }

    public MyDoubleLinked(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyDoubleLinked{" +
                "name='" + name + '\'' +
                '}';
    }
}
