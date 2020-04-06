package com.aote.avlTree;

import java.util.Arrays;

public class AVLTresTest {

    public static void main(String[] args) {
        //int[] arr = {4,3,6,5,7,8}; // 测试左旋数组
        //int[] arr = {10,12,8,9,7,6}; // 测试右旋数组
        int[] arr = {6,7,8,9,10,11};
        AVLTree avlTree = new AVLTree();
        // 添加节点
        for(int i=0;i<arr.length;i++){
            avlTree.add(new Node(arr[i]));
        }

        // 遍历
        avlTree.infixOrder();
        System.out.println(Arrays.toString(arr));
        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().rightHeight());
        System.out.println(avlTree.getRoot().leftHeight());
    }

}
