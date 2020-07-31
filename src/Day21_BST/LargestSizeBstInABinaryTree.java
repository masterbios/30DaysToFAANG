package Day21_BST;

public class LargestSizeBstInABinaryTree {

    final long inf = Long.MAX_VALUE;

    public void solve(Node root) {
        long ans = dfs(root).ans;
    }

    private Pair dfs(Node root) {
        if (root == null) {
            return new Pair(-inf, inf, 0, 0, true);
        }

        if (root.left == null && root.right == null) {
            return new Pair(root.val, root.val, 1, 1, true);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        long size = 1 + left.size + right.size;

        if (left.isBst && right.isBst && left.max < root.val && root.val < right.min) {
            long min = Math.min(left.min, Math.min(right.min, root.val));
            long max = Math.max(left.max, Math.max(right.max, root.val));
            return new Pair(min, max, size, size, true);
        }

        return new Pair(-inf, inf, size, Math.max(left.ans, right.ans), false);
    }

    class Pair {
        long min, max, size, ans;
        boolean isBst;
        public Pair(long min, long max, long size, long ans, boolean isBst) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.ans = ans;
            this.isBst = isBst;
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
