package org.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    // 树的根节点
    private org.Tree.TreeNode root;

    // 默认构造函数
    public Tree() {
        this.root = null;
    }

    // 带根节点的构造函数
    public Tree(org.Tree.TreeNode root) {
        this.root = root;
    }

    // 获取根节点
    public org.Tree.TreeNode getRoot() {
        return root;
    }

    // 设置根节点
    public void setRoot(org.Tree.TreeNode root) {
        this.root = root;
    }

    // 判断树是否为空
    public boolean isEmpty() {
        return root == null;
    }

    // 深度优先遍历（前序）
    public void depthFirstTraversal() {
        depthFirstTraversal(root);
        System.out.println();
    }

    private void depthFirstTraversal(org.Tree.TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            for (org.Tree.TreeNode child : node.children) {
                depthFirstTraversal(child);
            }
        }
    }

    // 广度优先遍历（层序）
    public void breadthFirstTraversal() {
        if (root == null) {
            return;
        }

        Queue<org.Tree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            org.Tree.TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            for (org.Tree.TreeNode child : node.children) {
                if (child != null) {
                    queue.offer(child);
                }
            }
        }
        System.out.println();
    }

    // 中序遍历（对于多叉树的变体实现）
    public void inorderTraversal() {
        // 主函数，调用实际实现
        inorderHelper(root);
        System.out.println();
    }
    
    // 辅助函数，实现多叉树的中序遍历逻辑
    private void inorderHelper(org.Tree.TreeNode node) {
        // 对于多叉树，我们采用以下策略实现中序遍历：
        // 1. 遍历前一半子树
        // 2. 访问根节点
        // 3. 遍历后一半子树
        
        if (node != null) {
            int childCount = node.getChildrenCount();
            int mid = childCount / 2;
            
            // 遍历前一半子树
            for (int i = 0; i < mid; i++) {
                inorderHelper(node.getChild(i));
            }
            
            // 访问根节点
            System.out.print(node.val + " ");
            
            // 遍历后一半子树
            for (int i = mid; i < childCount; i++) {
                inorderHelper(node.getChild(i));
            }
        }
    }
}