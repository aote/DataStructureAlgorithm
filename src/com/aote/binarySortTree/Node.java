package com.aote.binarySortTree;

/**
 * 创建Node节点
 */
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 添加节点的方法
    //递归的形式添加节点，注意需要满足二叉排序树的要求
    public void add(Node node){
        if(node == null){
            return;
        }
        // 判断传入的节点的值和当前子树的根节点的值的关系
        if(node.value<this.value){
            // 如果当前节点左子节点为null
            if(this.left == null){
                this.left = node;
            } else {
                // 递归向左子树添加
                this.left.add(node);
            }
        } else {
            // 添加的节点值大于当前节点的值
            if(this.right == null){
                this.right = node;
            } else {
                // 否则递归向右子树添加
                this.right.add(node);
            }
        }
    }

    // 中序遍历
    public void infixOrder(){
        // 递归向左子树中序遍历
        if(this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        // 递归向右子树中序遍历
        if(this.right != null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
