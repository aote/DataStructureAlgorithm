package com.aote.linkedList;

import java.util.Stack;

/**
 * 新增、操作链表的类
 */
public class LinkedListUtil {

    // 初始化一个头节点，不存放具体数据
    private MyNode headNode = new MyNode(0,"头节点");

    public void add(MyNode myNode){
        MyNode temp = headNode;
        while (true) {
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = myNode;
    }

    public void myList(){
        MyNode temp = headNode;
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
        MyNode temp = headNode;
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

        MyNode cur = headNode.next;
        MyNode newNode = new MyNode(0,"头节点");
        MyNode next = null;
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
        MyNode cur = headNode.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

}
