package com.aote.doubleLinedList;

public class DoubleLinkedTest {

    public static void main(String[] args) {

        MyDoubleLinked n1 = new MyDoubleLinked(1,"a");
        MyDoubleLinked n2 = new MyDoubleLinked(2,"b");
        MyDoubleLinked n3 = new MyDoubleLinked(3,"c");
        DoubleLinkedListUtil doubleLinkedListUtil = new DoubleLinkedListUtil();

        doubleLinkedListUtil.add(n3);
        doubleLinkedListUtil.add(n1);
        doubleLinkedListUtil.add(n2);
        doubleLinkedListUtil.myList();

    }

}
