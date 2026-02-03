package org.Tree;

public class TestTree {
    public static void main(String[] args) {
        // 创建一个普通树结构
        //        1
        //    /   |   \
        //   2    3    4
        //  /|\   |   / \
        // 5 6 7  8  9  10
        
        org.Tree.TreeNode root = new org.Tree.TreeNode(1);
        
        org.Tree.TreeNode node2 = new org.Tree.TreeNode(2);
        org.Tree.TreeNode node3 = new org.Tree.TreeNode(3);
        org.Tree.TreeNode node4 = new org.Tree.TreeNode(4);
        
        root.addChild(node2);
        root.addChild(node3);
        root.addChild(node4);
        
        node2.addChild(new org.Tree.TreeNode(5));
        node2.addChild(new org.Tree.TreeNode(6));
        node2.addChild(new org.Tree.TreeNode(7));
        
        node3.addChild(new org.Tree.TreeNode(8));
        
        node4.addChild(new org.Tree.TreeNode(9));
        node4.addChild(new org.Tree.TreeNode(10));

        // 创建Tree对象
        org.Tree.Tree tree = new org.Tree.Tree(root);

        // 测试树的基本功能
        System.out.println("根节点的值: " + tree.getRoot().val);
        System.out.println("根节点的子节点数量: " + tree.getRoot().getChildrenCount());
        System.out.println("树是否为空: " + tree.isEmpty());
        
        // 遍历根节点的所有直接子节点
        System.out.println("根节点的直接子节点:");
        for (int i = 0; i < root.getChildrenCount(); i++) {
            System.out.print(root.getChild(i).val + " ");
        }
        System.out.println();
        
        // 深度优先遍历
        System.out.println("深度优先遍历:");
        tree.depthFirstTraversal();
        
        // 广度优先遍历
        System.out.println("广度优先遍历:");
        tree.breadthFirstTraversal();
        
        // 中序遍历
        System.out.println("中序遍历:");
        tree.inorderTraversal();
    }
}