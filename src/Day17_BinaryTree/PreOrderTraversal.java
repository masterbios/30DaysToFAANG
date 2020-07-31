package Day17_BinaryTree;

import java.util.Stack;

public class PreOrderTraversal {

    public void iterative(Node root) {
        if (root == null) return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node cur = st.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) st.push(cur.right);
            if (cur.left != null) st.push(cur.left);
        }
    }

    public void recursive(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        recursive(root.left);
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
