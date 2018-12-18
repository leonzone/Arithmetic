package tree;

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
    public void del(int data){
        
    }
    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

}