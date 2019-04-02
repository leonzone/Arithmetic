package structure.tree;

/**
 * Date:2019/1/18
 * Des: 二分搜索树
 * 每个节点的值都大于左子树节点的值，小于右子树节点的值的二叉函数
 *
 * @author reiserx
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找
     *
     * @param
     */
    public Node find(int v) {
        Node p = tree;
        while (p != null) {
            if (v < p.data) {
                p = p.left;
            } else if (v > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return p;
    }

    /**
     * 插入
     *
     * @param
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    /**
     * 删除
     *
     * @param
     */
    public void delete(int data) {
        // p 指向要删除的节点，初始化指向根节点
        Node p = tree;
        // pp 记录的是 p 的父节点
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没有找到
        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        // 查找右子树中最小节点
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            // minPP 表示 minP 的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将 minP 的数据替换到 p 中
            p.data = minP.data;
            // 下面就变成了删除 minP 了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        // p 的子节点
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        if (pp == null) {
            // 删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    public void frontPrintAll(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        frontPrintAll(root.left);
        frontPrintAll(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void centerPrintAll(Node root) {
        if (root == null) {
            return;
        }
        centerPrintAll(root.left);
        System.out.print(root.data + "->");
        centerPrintAll(root.right);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void afterPrintAll(Node root) {
        if (root == null) {
            return;
        }
        afterPrintAll(root.left);
        afterPrintAll(root.right);
        System.out.print(root.data + "->");
    }

    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(33);
        tree.insert(16);
        tree.insert(50);
        tree.insert(13);
        tree.insert(18);
        tree.insert(34);
        tree.insert(58);
        tree.insert(15);
        tree.insert(17);
        tree.insert(25);
        tree.insert(51);
        tree.insert(66);
        tree.insert(19);
        tree.insert(27);
        tree.insert(55);

        tree.delete(13);
        tree.delete(18);
        tree.delete(55);

        BinarySearchTree.Node node2 = tree.find(19);
        System.out.println("node  left is " + node2.left.data);
        System.out.println("node  right is " + node2.right.data);


        tree.frontPrintAll(tree.find(33));
        System.out.println();
        tree.centerPrintAll(tree.find(33));
        System.out.println();
        tree.afterPrintAll(tree.find(33));
        System.out.println();

    }

}