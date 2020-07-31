package Day18_BinaryTree;

import Day17_BinaryTree.LeftViewOfBinaryTree;

import java.util.Stack;

public class SpiralBinaryTreeTraversal {

    // RLRLR
    public void solve(Node root) {
        recursive(root);
        iterative(root);
    }

    public void recursive(Node root) {
        if (root == null) return;
        int height = dfs(root);
        boolean leftToRight = false;
        for (int i = 1; i <= height; i++) {
            printSpiral(root, i, leftToRight);
            leftToRight = !leftToRight;
        }
    }

    public void printSpiral(Node root, int height, boolean leftToRight) {
        if (root == null) return;
        if (height == 1) {
            System.out.print(root.val + " ");
        } else if (height > 1) {
            if (leftToRight) {
                printSpiral(root.left, height - 1, leftToRight);
                printSpiral(root.right, height - 1, leftToRight);
            } else {
                printSpiral(root.right, height - 1, leftToRight);
                printSpiral(root.left, height - 1, leftToRight);
            }
        }
    }

    public int dfs(Node root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }

    public void iterative(Node root) {
        if (root == null) return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty() || st2.isEmpty()) {
            while (!st1.isEmpty()) {
                Node cur = st1.pop();
                System.out.print(cur.val + " ");
                if (cur.right != null) st2.push(cur.right);
                if (cur.left != null) st2.push(cur.left);
            }
            while (!st2.isEmpty()) {
                Node cur = st2.pop();
                System.out.print(cur.val + " ");
                if (cur.left != null) st1.push(cur.left);
                if (cur.right != null) st1.push(cur.right);
            }
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
