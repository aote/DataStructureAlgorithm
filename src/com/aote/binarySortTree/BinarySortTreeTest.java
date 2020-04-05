package com.aote.binarySortTree;

/**
 * 测试类
 */
public class BinarySortTreeTest {

    public static void main(String[] args) {

        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加节点到二叉排序树
        for(int i=0;i<arr.length;i++){
            binarySortTree.add(new Node(arr[i]));
        }
        // 中序遍历二叉排序树
        binarySortTree.infixOrder();

    }

}
