package Day20_BST;

import java.util.Stack;

public class ConstructBSTFromPreOrderTraversal {

    public void solve(int preorder[]) {
        Node tree = iterative(preorder);
    }

    private Node iterative(int preorder[]) {
        int n = preorder.length;
        Node root = new Node(preorder[0]);
        Stack<Node> st = new Stack<>();
        st.push(root);

        for (int i = 1; i < n; i++) {
            int x = preorder[i];
            Node cur = null;
            // keep poping until top of stack is less than current value
            while (!st.isEmpty() && st.peek().val < x) {
                cur = st.pop();
            }
            // make right child of lowerbound value of current value
            if (cur != null) {
                cur.right = new Node(x);
                st.push(cur.right);
            } else { // when current element is less than stack top
                cur = st.peek();
                cur.left = new Node(x);
                st.push(cur.left);
            }
        }

        return root;
    }

    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
}
