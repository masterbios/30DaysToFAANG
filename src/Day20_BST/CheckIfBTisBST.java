package Day20_BST;

import java.util.Stack;

public class CheckIfBTisBST {
    public void solve(Node root){

    }

    public boolean recursive(Node root, int min, int max) {
        if (root == null) return true;
        if (!(min < root.val && root.val < max)) return false;
        return  (recursive(root.left, min, root.val) &&
                recursive(root.right, root.val, max));
    }

    public boolean iterative(Node root) {
        if (root == null) return true;
        long prev = Long.MIN_VALUE;
        Node cur = root;
        Stack<Node> st = new Stack<>();

        while (!st.isEmpty() || cur != null) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if (prev >= cur.val) return false;
            prev = cur.val;
            cur = cur.right;
        }

        return true;
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
