package org.BinaryTree;

// 定义二叉树节点类
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // 默认构造函数
    public TreeNode() {}

    // 带值的构造函数
    public TreeNode(int val) {
        this.val = val;
    }

    // 完整构造函数
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void addChild(TreeNode node2) {
        if (this.left == null) {
            this.left = node2;
        } else if (this.right == null) {
            this.right = node2;
        }
        // 如果左右子树都已存在，则不添加（作为二叉树节点）
    }

    public int getChildrenCount() {
        int count = 0;
        if (this.left != null) {
            count++;
        }
        if (this.right != null) {
            count++;
        }
        return count;
    }
}