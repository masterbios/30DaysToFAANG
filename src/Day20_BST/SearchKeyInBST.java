package Day20_BST;

public class SearchKeyInBST {

    public void solve(Node root, int key) {
        Node p1 = recursive(root, key);
        Node p2 = iterative(root, key);
    }

    public Node recursive(Node root, int key) {
        if (root == null) return root;
        if (root.val == key) return root;
        else if (key > root.val) return recursive(root.left, key);
        else  return recursive(root.right, key);
    }

    public Node iterative(Node root, int key) {
        while (root != null) {
            if (root.val == key) return root;
            else if (root.val > key) root = root.left;
            else root = root.right;
        }
        return null;
    }


    class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}
