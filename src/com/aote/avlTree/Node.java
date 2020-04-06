package com.aote.avlTree;

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

    // 左旋转方法
    public void leftRotate(){
        // 创建新节点，以当前节点的值
        Node newNode = new Node(value);
        // 把新的节点的左子树设置成当前节点的左子树
        newNode.left = left;
        // 把新的节点的右子树设置成当前节点右子树的左子树
        newNode.right = right.left;
        // 把当前节点的值替换成右子节点的值
        value = right.value;
        // 把当前节点的右子树设置成当前节点右子树的右子树
        right = right.right;
        // 把当前节点的左子树设置成新的节点
        left = newNode;

    }

    // 右旋转方法
    public void rightRotate(){
        // 创建新节点，以当前节点的值
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    // 返回左子树的高度
    public int leftHeight(){
        if(left == null){
            return 0;
        } else {
            return left.height();
        }
    }

    // 返回右子树的高度
    public int rightHeight(){
        if(right == null){
            return 0;
        } else {
            return right.height();
        }
    }

    // 返回以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null ? 0:left.height(),right==null ? 0:right.height()) + 1;
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

        // 当添加完一个节点后，(右子树的高度-左子树高度)>1，做左旋转，反之右旋转
        if(rightHeight() - leftHeight() > 1){
            // 如果右子树的左子树的高度大于它的右子树的高度，则右子树要右旋
            if(right != null && right.leftHeight()>right.rightHeight()){
                // 先对当前节点的右子树进行右旋
                right.rightRotate();
                // 在对当前节点左旋转
                leftRotate();
            } else {
                // 左旋转
                leftRotate();
            }
            return;
        }
        if (leftHeight() - rightHeight() > 1){
            // 如果左子树的右子树的高度大于它的左子树的高度，则左子树要左旋
            if(left != null && left.rightHeight()>left.leftHeight()){
                // 先对当前节点的左子树进行左旋
                left.leftRotate();
                // 再对当前节点进行右旋转
                rightRotate();
            } else {
                // 右旋转
                rightRotate();
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
