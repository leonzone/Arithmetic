package tree;

public class test {
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