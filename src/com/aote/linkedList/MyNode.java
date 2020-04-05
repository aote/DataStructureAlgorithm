package com.aote.linkedList;

/**
 * 链表对象
 */
public class MyNode {

    public int no;
    public MyNode next;
    public String name;

    public MyNode() {
    }

    public MyNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
