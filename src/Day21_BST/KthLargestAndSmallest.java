package Day21_BST;

import java.util.Stack;

public class KthLargestAndSmallest {

    public void solve(Node root, int k) {

    }
    int count = 0;
    public Node recursive(Node root, int k) {
        if (root == null) return root;
        Node left = recursive(root.left, k);
        if (left != null) return left;
        this.count++;
        if (this.count == k) return root;
        return recursive(root.right, k);
    }

    public Node iterative(Node root, int k) {
        if (root == null) return root;
        Stack<Node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k--;
            if (k == 0) return root;
            root = root.right;
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
