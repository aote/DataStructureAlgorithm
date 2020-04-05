package com.aote.linkedList;

public class LinkedTest {

    public static void main(String[] args) {

        MyNode m1 = new MyNode();
        MyNode m2 = m1;

        MyNode n1 = new MyNode(1,"a");
        MyNode n2 = new MyNode(2,"b");
        MyNode n3 = new MyNode(3,"c");
        LinkedListUtil myNodeList = new LinkedListUtil();

        myNodeList.add(n1);
        myNodeList.add(n2);
        myNodeList.add(n3);

//        myNodeList.headInsert();
        myNodeList.stackPrint();

    }

}
