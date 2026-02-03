package org.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    // 默认构造函数
    public BinaryTree() {
        this.root = null;
    }

    // 带根节点的构造函数
    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // 获取根节点
    public TreeNode getRoot() {
        return root;
    }

    // 设置根节点
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 判断树是否为空
    public boolean isEmpty() {
        return root == null;
    }

    // 前序遍历 - 递归实现
    public void preorderTraversal() {
        preorderTraversal(root);
        System.out.println();
    }

    private void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // 前序遍历 - 非递归实现
    public void preorderTraversalIterative() {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            // 先压入右子树，再压入左子树（因为栈是后进先出）
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();
    }

    // 中序遍历 - 递归实现
    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    // 后序遍历 - 递归实现
    public void postorderTraversal() {
        postorderTraversal(root);
        System.out.println();
    }

    private void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }

    // 后序遍历 - 非递归实现
    public void postorderTraversalIterative() {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        java.util.List<Integer> result = new java.util.LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(0, node.val); // 在列表开头插入值

            // 先压入左子树，再压入右子树
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // 打印结果
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // 层序遍历
    public void levelOrderTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println();
    }
}