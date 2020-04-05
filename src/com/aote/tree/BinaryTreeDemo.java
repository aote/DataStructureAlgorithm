package com.aote.tree;

/**
 * 二叉树测试类
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,"a");
        TreeNode treeNode2 = new TreeNode(2,"b");
        TreeNode treeNode3 = new TreeNode(3,"c");
        TreeNode treeNode4 = new TreeNode(4,"d");
        TreeNode treeNode5 = new TreeNode(5,"e");

        root.setLeft(treeNode2);
        root.setRight(treeNode3);
        treeNode3.setRight(treeNode4);
        treeNode3.setLeft(treeNode5);

        // 测试遍历树
//        root.infixOrder();

        // 测试查找某个节点
        TreeNode res = root.postSearch(3);
        System.out.println(res.toString());

        // 测试删除节点
        //root.deleteNode(3);
        //root.preOrder();

    }



}