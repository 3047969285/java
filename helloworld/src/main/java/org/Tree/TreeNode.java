package org.Tree;

import java.util.ArrayList;
import java.util.List;

// 定义普通树节点类（多叉树）
public class TreeNode {
    public int val;
    public List<TreeNode> children;

    // 默认构造函数
    public TreeNode() {
        this.children = new ArrayList<>();
    }

    // 带值的构造函数
    public TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    // 带值和子节点列表的构造函数
    public TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children != null ? children : new ArrayList<>();
    }

    // 添加子节点
    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    // 移除子节点
    public void removeChild(TreeNode child) {
        this.children.remove(child);
    }

    // 获取子节点数量
    public int getChildrenCount() {
        return this.children.size();
    }

    // 获取指定索引的子节点
    public TreeNode getChild(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }
}