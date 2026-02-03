package org.BinaryTree;

public class TestBinaryTree {
    public static void main(String[] args) {
        // 创建一个二叉树
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 创建BinaryTree对象
        BinaryTree tree = new BinaryTree(root);

        // 测试各种遍历方法
        System.out.println("前序遍历(递归):");
        tree.preorderTraversal();

        System.out.println("前序遍历(非递归):");
        tree.preorderTraversalIterative();

        System.out.println("中序遍历:");
        tree.inorderTraversal();

        System.out.println("后序遍历(递归):");
        tree.postorderTraversal();

        System.out.println("后序遍历(非递归):");
        tree.postorderTraversalIterative();

        System.out.println("层序遍历:");
        tree.levelOrderTraversal();

        // 测试其他方法
        System.out.println("树是否为空: " + tree.isEmpty());
        System.out.println("根节点的值: " + tree.getRoot().val);
    }
}