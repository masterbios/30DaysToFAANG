package Day18_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckIfTwoTreesAreIdentical {

    public void solve(Node tree1, Node tree2) {
        System.out.println(recursive(tree1, tree2));
        System.out.println(iterative(tree1, tree2));
    }

    private boolean iterative(Node v1, Node v2) {
        if (v1 == null && v2 == null) return true;
        if (v1 == null || v2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.offer(v1);
        q2.offer(v2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            Node cur1 = q1.poll(), cur2 = q2.poll();
            if (cur1.val != cur2.val) return false;

            if (cur1.left != null && cur2.left != null) {
                q1.offer(cur1.left);
                q2.offer(cur2.left);
            } else if (cur1.left != null || cur2.left != null) {
                return false;
            }

            if (cur1.right != null && cur2.right != null) {
                q1.offer(cur1.right);
                q2.offer(cur2.right);
            } else if (cur1.right != null || cur2.right != null) {
                return false;
            }

        }
        return true;
    }

    // Time complexity : O(m) AND M < N
    private boolean recursive(Node v1, Node v2) {
        if (v1 == null && v2 == null) return true;
        if (v1 == null || v2 == null) return false;
        return ((v1.val == v2.val) &&
                recursive(v1.left, v2.left) &&
                recursive(v1.right, v2.right));
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
