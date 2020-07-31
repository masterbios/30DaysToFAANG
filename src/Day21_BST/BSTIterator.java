package Day21_BST;

import java.util.Stack;

public class BSTIterator {

    Stack<Node> st;

    public BSTIterator(Node root) {
        st = new Stack<>();
        leftInorder(root);
    }

    public Node next() {
        Node cur = st.pop();
        if (cur.right != null) {
            leftInorder(cur.right);
        }
        return cur;
    }

    public boolean hasNext() {
        return st.isEmpty();
    }

    private void leftInorder(Node root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
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
