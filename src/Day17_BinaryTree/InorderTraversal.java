package Day17_BinaryTree;

import java.util.Stack;

public class InorderTraversal {

    public void iterative(Node root) {
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        Node cur = root;
        while (!st.isEmpty() ||  cur != null) {
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public void recursive(Node root) {
        if (root == null) return;
        recursive(root.left);
        System.out.print(root.val + " ");
        recursive(root.right);
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
