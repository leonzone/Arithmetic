package structure.tree;

/**
 * Author: reiserx
 * Date:2019/1/18
 * Des: 二分搜索树
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int v) {
        Node p = tree;
        while (p != null) {
            if (v < p.data)
                p = p.left;
            else if (v > p.data)
                p = p.right;
            else
                return p;
        }
        return p;
    }

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

    public void del(int data) {

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
        BinarySearchTree tree=new BinarySearchTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        BinarySearchTree.Node node=tree.find(2);
        System.out.println("node 2 left is "+node.left.data);
        System.out.println("node 2 right is "+node.right.data);

    }

}