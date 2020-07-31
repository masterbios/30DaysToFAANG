package Day17_BinaryTree;

import java.util.Stack;

public class PostOrderTraversal {

    public void iterative1(Node root) {
        if (root == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            Node cur = s1.pop();
            s2.push(cur);
            if (cur.left != null) s1.push(cur.left);
            if (cur.right != null) s1.push(cur.right);
        }
        while (!s2.isEmpty()) System.out.print(s2.pop().val + " ");
    }

    public void iterative2(Node root) {
        if (root == null) return;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        while (!st.isEmpty()) {
            Node cur = st.peek().first;
            int pos = st.peek().second;
            st.pop();

            if (pos == 0) {
                st.push(new Pair(cur, 1));
                if (cur.left != null) st.push(new Pair(cur.left, 1));
            } else if (pos == 1) {
                st.push(new Pair(cur, 2));
                if (cur.right != null) st.push(new Pair(cur.right, 2));
            } else { // pos = 2;
                System.out.print(cur.val + " ");
            }
        }
    }

    public void recursive(Node root) {
        if (root == null) return;
        recursive(root.left);
        recursive(root.right);
        System.out.print(root.val + " ");
    }


    class Pair {
        Node first;
        int second;
        public Pair(Node first, int second) {
            this.first = first;
            this.second = second;
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
