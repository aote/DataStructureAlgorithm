package com.aote.doubleLinedList;

import sun.jvm.hotspot.oops.BranchData;

import java.util.Stack;

/**
 * 新增、操作链表的类
 */
public class DoubleLinkedListUtil {

    // 初始化一个头节点，不存放具体数据
    private MyDoubleLinked headNode = new MyDoubleLinked(0,"头节点");

    public void add(MyDoubleLinked myDoubleLinked){
        MyDoubleLinked temp = headNode;
        while (true){
            if (temp.next == null) {
                // 将传入的节点赋值给temp的下一个节点
                temp.next = myDoubleLinked;
                myDoubleLinked.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    public void update(int no){
        MyDoubleLinked temp = headNode.next;
        while (true) {
            if(temp.no == no){

            }
        }

    }

    public void delete(int no){
        MyDoubleLinked temp = headNode.next;
        if(temp == null){
            return;
        }
        while (true) {
            if(temp.no == no){
                temp.pre.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }
                break;
            }
            temp = temp.next;
        }
    }

    public void myList(){
        MyDoubleLinked temp = headNode;
        if(temp.next == null){
            System.out.println("头节点为空");
            return;
        }
        while (true) {
            System.out.println(temp.next);
            temp = temp.next;
            if (temp.next ==null){
                break;
            }
        }
    }

    public void list(){
        MyDoubleLinked temp = headNode;
        if(temp.next == null){
            System.out.println("头节点为空");
            return;
        }
        temp = temp.next;
        while (true){
            if(temp != null){
                System.out.println(temp);
                temp = temp.next;
            } else {
                break;
            }
        }
    }

    /**
     * 翻转链表结构，使用头部插入法
     */
    public void headInsert(){
        // 如果链表为空或只有一个节点不用处理
        if(headNode == null || headNode.next == null){
            return;
        }

        MyDoubleLinked cur = headNode.next;
        MyDoubleLinked newNode = new MyDoubleLinked(0,"头节点");
        MyDoubleLinked next = null;
        while (cur != null){
            next = cur.next;
            cur.next = newNode.next;
            newNode.next = cur;
            cur = next;
        }
        headNode.next = newNode.next;
    }

    /**
     * 倒序输入列表数据，使用栈处理
     */
    public void stackPrint(){
        Stack stack = new Stack();
        MyDoubleLinked cur = headNode.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}
