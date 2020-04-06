package com.aote.avlTree;

/**
 * 平衡二叉树
 */
public class AVLTree {

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
            System.out.println("AVL树为空");
        }
    }

    public Node getRoot() {
        return root;
    }
}
