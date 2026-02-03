package org.Red_Black_Tree;

public class RBTreeTest {
    public static void main(String[] args) {
        // 创建红黑树实例
        RBTree<Integer, String> rbTree = new RBTree<>();

        System.out.println("=== 红黑树测试 ===");

        // 测试插入操作
        System.out.println("\n1. 插入节点:");
        int[] keys = {10, 5, 15, 3, 7, 12, 18, 1, 6, 9, 11, 13, 17, 25};
        String[] values = {"Ten", "Five", "Fifteen", "Three", "Seven",
                "Twelve", "Eighteen", "One", "Six", "Nine",
                "Eleven", "Thirteen", "Seventeen", "Twenty-Five"};

        for (int i = 0; i < keys.length; i++) {
            System.out.println("插入: Key=" + keys[i] + ", Value=" + values[i]);
            rbTree.put(keys[i], values[i]);
        }

        System.out.println("\n2. 中序遍历结果:");
        rbTree.inorderTraversal();

        // 测试查找操作
        System.out.println("\n3. 查找测试:");
        Integer searchKey = 7;
        String foundValue = rbTree.get(searchKey);
        System.out.println("查找 Key=" + searchKey + ", Value=" + foundValue);

        searchKey = 20; // 不存在的键
        foundValue = rbTree.get(searchKey);
        System.out.println("查找 Key=" + searchKey + ", Value=" + foundValue);

        // 测试删除操作
        System.out.println("\n4. 删除测试:");
        Integer deleteKey = 10;
        System.out.println("删除 Key=" + deleteKey);
        rbTree.remove(deleteKey);

        System.out.println("删除后的中序遍历:");
        rbTree.inorderTraversal();

        // 继续删除更多节点
        System.out.println("\n5. 继续删除:");
        Integer[] deleteKeys = {5, 15, 3};
        for (Integer key : deleteKeys) {
            System.out.println("删除 Key=" + key);
            rbTree.remove(key);
        }

        System.out.println("删除多个节点后的中序遍历:");
        rbTree.inorderTraversal();

        // 测试更多的插入和删除
        System.out.println("\n6. 更多操作测试:");
        rbTree.put(20, "Twenty");
        rbTree.put(22, "Twenty-Two");
        rbTree.put(8, "Eight");

        System.out.println("插入20, 22, 8后的遍历:");
        rbTree.inorderTraversal();

        // 测试边界情况
        System.out.println("\n7. 边界情况测试:");
        RBTree<String, Integer> stringTree = new RBTree<>();
        stringTree.put("apple", 1);
        stringTree.put("banana", 2);
        stringTree.put("cherry", 3);
        stringTree.put("date", 4);
        stringTree.put("elderberry", 5);

        System.out.println("字符串红黑树遍历:");
        stringTree.inorderTraversal();

        System.out.println("\n查找 'cherry': " + stringTree.get("cherry"));
        System.out.println("查找 'grape': " + stringTree.get("grape"));

        // 性能测试 - 大量数据
        System.out.println("\n8. 性能测试 (插入100个随机数):");
        RBTree<Integer, Integer> largeTree = new RBTree<>();

        // 插入1-100的数字
        for (int i = 1; i <= 100; i++) {
            largeTree.put(i, i * 2);
        }

        System.out.println("插入100个节点完成");
        System.out.println("根节点: " + largeTree.getRoot().getKey());
        System.out.println("根节点颜色: " + (largeTree.getRoot().getColor() == RBTree.BLACK ? "BLACK" : "RED"));

        // 验证几个特定值
        System.out.println("查找50: " + largeTree.get(50));
        System.out.println("查找1: " + largeTree.get(1));
        System.out.println("查找100: " + largeTree.get(100));

        // 删除一半数据
        System.out.println("\n删除50个节点...");
        for (int i = 1; i <= 50; i += 2) { // 删除奇数
            largeTree.remove(i);
        }

        System.out.println("删除奇数后查找偶数:");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println("Key " + i + ": " + largeTree.get(i));
        }
        System.out.println("查找已删除的奇数5: " + largeTree.get(5));

        System.out.println("\n=== 测试完成 ===");
    }
}
