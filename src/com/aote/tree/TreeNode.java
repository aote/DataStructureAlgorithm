package com.aote.tree;

public class TreeNode {

    private int no;
    private String name;
    private TreeNode left;
    private TreeNode right;

    //1.如果leftType==0，表示指向的是左子树，如果1则表示指向前驱节点
    private int leftType;
    //2.如果rightType==0，表示指向右子树，如果1表示指向后继节点
    private int rightType;
    // 为了实现线索化，需要创建一个指向当前节点的前驱节点的指针
    private TreeNode pre = null;

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(TreeNode node){
        // 如果node==null，不能线索化
        if(node == null){
            return;
        }
        // 1.先线索化左子树
        threadedNodes(node.getLeft());

        // 2.线索化当前节点
        // 先处理当前节点的前驱节点
        if(node.getLeft() == null ){
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }
        // 处理后继节点
        if(pre!=null && pre.getRight()==null){
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型
            pre.setRightType(1);
        }

        // !!!每处理一个节点后，让当前节点变成现 一个节点的前驱节点
        pre = node;

        // 3.线索化右子树
        threadedNodes(node.getRight());
    }

    // 遍历线索化二叉树的方法
    public void threadedList(TreeNode root){
        // 从当前节点开始遍历，必须是root
        TreeNode node = root;
        while(node != null){
            // 循环找到leftType==1的节点，第一个找到的就是8节点
            // 后面随着遍历而变化，因为当leftType==1时，
            // 说明该节点是按照线索化处理后的有效节点
            while(node.getLeftType()==0){
                node = node.getLeft();
            }
            // 打印当前节点
            System.out.println(node);

            //如果当前节点的右指针指向的是后继节点，就一直输出
            while(node.getRightType()==1){
                // 获取当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换这个遍历的节点
            node = node.getRight();
        }

    }

    // 前序遍历方法
    public void preOrder(){
        System.out.println(this); // 先输出父节点
        // 递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
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

    // 后序遍历
    public void postOrder(){
        // 递归向左子树后序遍历
        if(this.left != null){
            this.left.postOrder();
        }
        // 递归向右子树后序遍历
        if(this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找
    public TreeNode preSearch(int no){
        if(this.getNo()==no){
            return this;
        }
        // 判断当前节点的左子节点是否为空，如果不为空，则递归前序查找
        // 如果左递归前序查找找到节点，则返回
        TreeNode resNode = null;
        if(this.getLeft() != null){
            resNode = this.getLeft().preSearch(no);
        }
        // 说明找到节点
        if(resNode != null){
            return resNode;
        }
        // 右递归前序查找，找到节点，则返回
        if(this.getRight() != null){
            resNode = this.getRight().preSearch(no);
        }
        return resNode;
    }

    // 中序查找
    public TreeNode infixSearch(int no){
        TreeNode resNode = null;
        if(this.getLeft() != null){
            resNode = this.getLeft().infixSearch(no);
        }
        // 说明找到节点
        if(resNode != null){
            return resNode;
        }
        if(this.getNo()==no){
            return this;
        }
        // 右递归前序查找，找到节点，则返回
        if(this.getRight() != null){
            resNode = this.getRight().infixSearch(no);
        }
        return resNode;
    }

    // 后序查找
    public TreeNode postSearch(int no){
        TreeNode resNode = null;
        if(this.getLeft() != null){
            resNode = this.getLeft().infixSearch(no);
        }
        // 说明找到节点
        if(resNode != null){
            return resNode;
        }
        // 右递归前序查找，找到节点，则返回
        if(this.getRight() != null){
            resNode = this.getRight().infixSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.getNo()==no){
            return this;
        } else {
            return null;
        }
    }

    // 删除节点
    public void deleteNode(int no){
        if(this == null){
            return;
        }
        if(this.getLeft() != null && this.getLeft().getNo() == no){
            this.left = null;
            return;
        }
        if(this.getLeft() != null){
            this.getLeft().deleteNode(no);
        }
        if(this.getRight() != null && this.getRight().getNo() == no){
            this.right = null;
            return;
        }
        if(this.getRight() != null){
            this.getRight().deleteNode(no);
        }
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
