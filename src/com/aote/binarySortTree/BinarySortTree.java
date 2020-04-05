package com.aote.binarySortTree;

/**
 * 创建二叉排序树
 */
public class BinarySortTree {

    private Node root;

    //添加节点方法
    public void add(Node node){
        if(root == null){
            root = node; //如果root为空直接让root指向node
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder(){
        if(root != null){
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空");
        }
    }

}
