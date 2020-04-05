package com.aote.tree;

/**
 * 数组方式存储二叉树
 * 顺序存储二叉树
 * 公式：第n个元素的左子节点为2*n+1
 *      第n个元素的右子节点为2*n+2
 *      第n个元素的父节点为(n-1)/2
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.infixOrder(0);
    }

}

class ArrBinaryTree {

    // 存储数据节点的数组
    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    // 编写一个方法，完成顺序存储的二叉树的前序遍历
    public void preOrder(int index){
        // 如果数组为空，或者arr.length=0
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        // 输出当前元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if((2*index+1)<arr.length){
            preOrder(2*index+1);
        }
        // 向右递归遍历
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    // 中序遍历
    public void infixOrder(int index){
        // 如果数组为空，或者arr.length=0
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        // 向左递归遍历
        if((2*index+1)<arr.length){
            infixOrder(2*index+1);
        }
        // 输出当前元素
        System.out.println(arr[index]);
        // 向右递归遍历
        if((index*2+2)<arr.length){
            infixOrder(index*2+2);
        }
    }

    // 后序遍历
    public void postOrder(int index){
        // 如果数组为空，或者arr.length=0
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        // 向左递归遍历
        if((2*index+1)<arr.length){
            postOrder(2*index+1);
        }
        // 向右递归遍历
        if((index*2+2)<arr.length){
            postOrder(index*2+2);
        }
        // 输出当前元素
        System.out.println(arr[index]);
    }

}