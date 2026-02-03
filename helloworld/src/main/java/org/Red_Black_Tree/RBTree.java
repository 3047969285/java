package org.Red_Black_Tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RBTree<K extends Comparable<K>, V> {

     static final boolean RED = false;
     static final boolean BLACK = true;
    // root节点
    private RBnode<K, V> root;

    // 左旋转
    private void leftRotate(RBnode<K, V> p) {
        if (p != null) {
            RBnode<K, V> r = p.right; // 右孩子

            // 将r的左子树接到p的右子树位置
            p.right = r.left;
            if (r.left != null) {
                r.left.parent = p;
            }

            // 处理p的父节点
            r.parent = p.parent;
            if (p.parent == null) {
                root = r; // p原来是根节点
            } else if (p == p.parent.left) {
                p.parent.left = r;
            } else {
                p.parent.right = r;
            }

            // 将p作为r的左孩子
            r.left = p;
            p.parent = r;
        }
    }

    // 右旋转
    private void rightRotate(RBnode<K, V> p) {
        if (p != null) {
            RBnode<K, V> l = p.left; // 左孩子

            // 将l的右子树接到p的左子树位置
            p.left = l.right;
            if (l.right != null) {
                l.right.parent = p;
            }

            // 处理p的父节点
            l.parent = p.parent;
            if (p.parent == null) {
                root = l; // p原来是根节点
            } else if (p == p.parent.left) {
                p.parent.left = l;
            } else {
                p.parent.right = l;
            }

            // 将p作为l的右孩子
            l.right = p;
            p.parent = l;
        }
    }

    /**
     * 红黑树新增节点的操作
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        RBnode<K, V> t = root;
        if (t == null) {
            root = new RBnode<>(key, value == null ? (V) key : value, null);
            root.color = RED; // 新插入的节点为红色
            // 新增节点后需要调整平衡
            fixUp(root);
            return;
        }

        // 查找要插入的点
        RBnode<K, V> parent;
        int cmp;
        do {
            parent = t;
            cmp = key.compareTo(t.key);
            if (cmp < 0)
                t = t.left;
            else if (cmp > 0)
                t = t.right;
            else {
                t.setValue(value == null ? (V) key : value);
                return;
            }
        } while (t != null);

        // 加入新节点
        RBnode<K, V> node = new RBnode<>(key, value == null ? (V) key : value, parent);
        node.color = RED; // 新插入的节点为红色
        if (cmp < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        // 插入新节点后需要调整平衡
        fixUp(node);
    }

    /**
     * 删除节点
     * @param key
     */
    public void remove(K key) {
        RBnode<K, V> node = findNode(key);
        if (node != null) {
            deleteNode(node);
        }
    }

    /**
     * 查找节点
     * @param key
     * @return
     */
    public V get(K key) {
        RBnode<K, V> node = findNode(key);
        return node != null ? node.getValue() : null;
    }

    /**
     * 查找指定键的节点
     * @param key
     * @return
     */
    private RBnode<K, V> findNode(K key) {
        RBnode<K, V> current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0) {
                current = current.left;
            } else if (cmp > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    // 封装方法
    private RBnode<K, V> parentof(RBnode<K, V> node) {
        return node != null ? node.parent : null;
    }

    private RBnode<K, V> leftof(RBnode<K, V> node) {
        return node != null ? node.left : null;
    }

    private RBnode<K, V> rightof(RBnode<K, V> node) {
        return node != null ? node.right : null;
    }

    private boolean color(RBnode<K, V> node) {
        return node == null ? BLACK : node.color;
    }

    private void setColor(RBnode<K, V> node, boolean color) {
        if (node != null)
            node.color = color;
    }

    /**
     * 调整平衡 - 修复红黑树性质
     * @param node 刚刚插入的节点（红色节点）
     */
    public void fixUp(RBnode<K, V> node) {
        // 当前节点不是根节点，且父节点是红色时需要修复
        while (node != null && node != root && color(parentof(node)) == RED) {
            RBnode<K, V> parent = parentof(node);

            // 父节点是祖父节点的左孩子
            if (parent == leftof(parentof(parent))) {
                RBnode<K, V> uncle = rightof(parentof(parent));

                // 情况1：叔叔节点是红色
                if (color(uncle) == RED) {
                    setColor(parent, BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentof(parent), RED);
                    node = parentof(parent); // 继续向上修复
                } else {
                    // 情况2：叔叔节点是黑色，当前节点是右孩子
                    if (node == rightof(parent)) {
                        node = parent;
                        leftRotate(node);
                        parent = parentof(node);
                    }

                    // 情况3：叔叔节点是黑色，当前节点是左孩子
                    setColor(parent, BLACK);
                    setColor(parentof(parent), RED);
                    rightRotate(parentof(parent));
                }
            }
            // 父节点是祖父节点的右孩子
            else {
                RBnode<K, V> uncle = leftof(parentof(parent));

                // 情况1：叔叔节点是红色
                if (color(uncle) == RED) {
                    setColor(parent, BLACK);
                    setColor(uncle, BLACK);
                    setColor(parentof(parent), RED);
                    node = parentof(parent); // 继续向上修复
                } else {
                    // 情况2：叔叔节点是黑色，当前节点是左孩子
                    if (node == leftof(parent)) {
                        node = parent;
                        rightRotate(node);
                        parent = parentof(node);
                    }

                    // 情况3：叔叔节点是黑色，当前节点是右孩子
                    setColor(parent, BLACK);
                    setColor(parentof(parent), RED);
                    leftRotate(parentof(parent));
                }
            }
        }

        // 确保根节点始终是黑色
        root.color = BLACK;
    }

    /**
     * 删除节点
     * @param node
     */
    private void deleteNode(RBnode<K, V> node) {
        RBnode<K, V> replacement = node.left != null && node.right != null ?
                findMin(node.right) : (node.left != null ? node.left : node.right);

        boolean originalColor = node.color;

        if (replacement == null) {
            // 要删除的节点是叶子节点
            if (node.parent == null) {
                root = null;
            } else {
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
                if (originalColor == BLACK) {
                    fixAfterDeletion(node);
                }
            }
        } else {
            // 替换节点存在
            K key = node.key;
            V val = node.value;

            node.key = replacement.key;
            node.value = replacement.value;
            node.color = replacement.color;

            replacement.key = key;
            replacement.value = val;

            if (node.left != null && node.right != null) {
                if (replacement == replacement.parent.left) {
                    replacement.parent.left = replacement.right;
                    if (replacement.right != null) {
                        replacement.right.parent = replacement.parent;
                    }
                } else {
                    replacement.parent.right = replacement.right;
                    if (replacement.right != null) {
                        replacement.right.parent = replacement.parent;
                    }
                }
            } else {
                if (replacement.parent == node) {
                    replacement.parent = node.parent;
                    if (node.parent == null) {
                        root = replacement;
                    } else if (node == node.parent.left) {
                        node.parent.left = replacement;
                    } else {
                        node.parent.right = replacement;
                    }
                } else {
                    if (replacement == replacement.parent.left) {
                        replacement.parent.left = replacement.right;
                    } else {
                        replacement.parent.right = replacement.right;
                    }
                    if (replacement.right != null) {
                        replacement.right.parent = replacement.parent;
                    }
                    replacement.left = node.left;
                    replacement.right = node.right;
                    replacement.parent = node.parent;
                    if (node.left != null) node.left.parent = replacement;
                    if (node.right != null) node.right.parent = replacement;
                    if (node.parent == null) {
                        root = replacement;
                    } else if (node == node.parent.left) {
                        node.parent.left = replacement;
                    } else {
                        node.parent.right = replacement;
                    }
                }
            }

            if (originalColor == BLACK) {
                fixAfterDeletion(replacement);
            }
        }
    }

    /**
     * 删除后的修复
     * @param node
     */
    private void fixAfterDeletion(RBnode<K, V> node) {
        while (node != root && color(node) == BLACK) {
            if (node == leftof(parentof(node))) {
                RBnode<K, V> sibling = rightof(parentof(node));

                if (color(sibling) == RED) {
                    setColor(sibling, BLACK);
                    setColor(parentof(node), RED);
                    leftRotate(parentof(node));
                    sibling = rightof(parentof(node));
                }

                if (color(leftof(sibling)) == BLACK && color(rightof(sibling)) == BLACK) {
                    setColor(sibling, RED);
                    node = parentof(node);
                } else {
                    if (color(rightof(sibling)) == BLACK) {
                        setColor(leftof(sibling), BLACK);
                        setColor(sibling, RED);
                        rightRotate(sibling);
                        sibling = rightof(parentof(node));
                    }
                    setColor(sibling, color(parentof(node)));
                    setColor(parentof(node), BLACK);
                    setColor(rightof(sibling), BLACK);
                    leftRotate(parentof(node));
                    node = root;
                }
            } else {
                RBnode<K, V> sibling = leftof(parentof(node));

                if (color(sibling) == RED) {
                    setColor(sibling, BLACK);
                    setColor(parentof(node), RED);
                    rightRotate(parentof(node));
                    sibling = leftof(parentof(node));
                }

                if (color(leftof(sibling)) == BLACK && color(rightof(sibling)) == BLACK) {
                    setColor(sibling, RED);
                    node = parentof(node);
                } else {
                    if (color(leftof(sibling)) == BLACK) {
                        setColor(rightof(sibling), BLACK);
                        setColor(sibling, RED);
                        leftRotate(sibling);
                        sibling = leftof(parentof(node));
                    }
                    setColor(sibling, color(parentof(node)));
                    setColor(parentof(node), BLACK);
                    setColor(leftof(sibling), BLACK);
                    rightRotate(parentof(node));
                    node = root;
                }
            }
        }
        setColor(node, BLACK);
    }

    /**
     * 查找最小节点
     * @param node
     * @return
     */
    private RBnode<K, V> findMin(RBnode<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 中序遍历打印树
     */
    public void inorderTraversal() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(RBnode<K, V> node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print("Key: " + node.key + ", Value: " + node.value +
                    ", Color: " + (node.color == RED ? "RED" : "BLACK") + " | ");
            inorderHelper(node.right);
        }
    }

    public RBnode<K, V> getRoot() {
        return root;
    }

    public void setRoot(RBnode<K, V> root) {
        this.root = root;
    }

    static class RBnode<K extends Comparable<K>, V> {
        private RBnode<K, V> parent;
        private RBnode<K, V> left;
        private RBnode<K, V> right;
        private boolean color;
        private K key;
        private V value;

        public RBnode(K key, V value, RBnode<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        // Getter and Setter methods
        public RBnode<K, V> getParent() { return parent; }
        public void setParent(RBnode<K, V> parent) { this.parent = parent; }
        public RBnode<K, V> getLeft() { return left; }
        public void setLeft(RBnode<K, V> left) { this.left = left; }
        public RBnode<K, V> getRight() { return right; }
        public void setRight(RBnode<K, V> right) { this.right = right; }
        public boolean getColor() { return color; }
        public void setColor(boolean color) { this.color = color; }
        public K getKey() { return key; }
        public void setKey(K key) { this.key = key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }
}
