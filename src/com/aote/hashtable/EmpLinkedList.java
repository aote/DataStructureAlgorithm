package com.aote.hashtable;

// 创建链表
public class EmpLinkedList {

    // 头指针，执行第一个emp，因此我们这个链表的head是指向第一个emp
    private Emp head; // 默认null

    // 添加员工到链表
    //1、当添加员工时，id是自增长，即id分配总是从小到大
    // 因此我们将该员工直接加入到本链表最后即可
    public void add(Emp emp){
        // 如果是添加第一个员工
        if(head == null){
            head = emp;
            return;
        }
        // 如果不是第一个员工，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true){
            if(curEmp.next == null){ // 说明到链表最后
                break;
            }
            // 后移
            curEmp = curEmp.next;
        }
        // 退出时直接将emp加入链表
        curEmp.next = emp;
    }

    // 遍历链表的emp数据
    public void list(int no){
        if(head == null){
            System.out.println("第"+no+"条链表为空");
            return;
        }
        System.out.println("第"+no+"条链表数据：");
        // 辅助指针
        Emp curEmp = head;
        while (true){
            System.out.println("id: "+curEmp.id +"，name："+curEmp.name);
            // 判断是否最后一个节点
            if(curEmp.next == null){
                break;
            }
            // 后移
            curEmp = curEmp.next;
        }
    }

    // 根据id查找雇员，如果查不到就返回null
    public Emp findEmpById(int id){
        // 判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        // 辅助指针
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){
                break;
            }
            // 说明便利当前链表没有找到该雇员
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}
