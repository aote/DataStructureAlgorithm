package com.aote.tree;

/**
 * 线索化二叉树
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,"tom");
        TreeNode node2 = new TreeNode(3,"jack");
        TreeNode node3 = new TreeNode(6,"smith");
        TreeNode node4 = new TreeNode(8,"mary");
        TreeNode node5 = new TreeNode(10,"king");
        TreeNode node6 = new TreeNode(14,"dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 将树线索化
        root.threadedNodes(root);
        // 遍历线索化后的树
        root.threadedList(root);

//        threadedNodesTest();
    }

    // 测试中序线索二叉树功能
    public static void threadedNodesTest(){
        TreeNode root = new TreeNode(1,"tom");
        TreeNode node2 = new TreeNode(3,"jack");
        TreeNode node3 = new TreeNode(6,"smith");
        TreeNode node4 = new TreeNode(8,"mary");
        TreeNode node5 = new TreeNode(10,"king");
        TreeNode node6 = new TreeNode(14,"dim");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 调用中序线索化方法
        root.threadedNodes(root);
        // 测试，以10号节点测试
        TreeNode leftNode = node5.getLeft();
        TreeNode rightNode = node5.getRight();
        System.out.println("10号节点的前驱节点是："+leftNode.toString()); //3
        System.out.println("10号节点的后继节点是："+rightNode.toString()); //1

    }

}
