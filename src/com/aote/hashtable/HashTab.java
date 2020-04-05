package com.aote.hashtable;

public class HashTab {

    private EmpLinkedList[] empLinkedListArray;
    private int size; //表示共有多少条列表

    public HashTab(int size) {
        // 初始化链表
        empLinkedListArray = new EmpLinkedList[size];
        this.size = size;
    }

    // 添加雇员
    public void add(Emp emp){
        // 根据员工的id得到该员工应该添加到哪条列表
        int empLinkerListNo = hashFun(emp.id);
        // 分别初始化每个链表
        for(int i=0;i<size;i++){
            if(empLinkedListArray[i]==null){
                empLinkedListArray[i] = new EmpLinkedList();
            }
        }
        // 将emp添加到对应的链表中
        empLinkedListArray[empLinkerListNo].add(emp);
    }

    // 编写一个散列函数(使用简单的取模法)
    public int hashFun(int id){
        return size%id;
    }

    // 遍历hash表
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list(i+1);
        }
    }

    // 根据id查询雇员
    public Emp findEmpById(int id){
        // 使用三列函数确定到哪条链表查询
        int empLinkerListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkerListNo].findEmpById(id);
        if(emp != null){
            System.out.println("在第"+empLinkerListNo+"中找到该雇员："+emp.name);
        } else{
            System.out.println("hashtab中没有找到该雇员");
        }
        return emp;
    }

}
