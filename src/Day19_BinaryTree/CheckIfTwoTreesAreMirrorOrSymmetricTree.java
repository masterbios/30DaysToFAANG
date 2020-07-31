package Day19_BinaryTree;

import java.util.Stack;

public class CheckIfTwoTreesAreMirrorOrSymmetricTree {
    public void solve(Node tree1, Node tree2) {

    }

    // both have time complexity : O(M) M = min(m, n)
    public boolean iterative(Node v1, Node v2) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        while (true) {
            while (v1 != null && v2 != null) {
                if (v1.val != v2.val) return false;
                st1.push(v1);
                st2.push(v2);
                v1 = v1.left;
                v2 = v2.right;
            }

            if (!(v1 == null && v2 == null)) return false;

            if (!st1.isEmpty() && !st2.isEmpty()) {
                v1 = st1.pop();
                v2 = st2.pop();
                v1 = v1.right;
                v2 = v2.left;
            } else {
                break;
            }
        }
        return true;
    }

    public boolean recursive(Node v1, Node v2) {
        if (v1 == null && v2 == null) return true;
        if (v1 == null || v2 == null) return false;
        return ((v1.val == v2.val) &&
                recursive(v1.left, v2.right) &&
                recursive(v1.right, v2.left));
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


