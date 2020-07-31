package Day19_BinaryTree;

public class MaxBinaryPathSum {

    int max;

    public void solve(Node root) {
        this.max = Integer.MIN_VALUE;
        dfs(root);
        System.out.println(max);
    }

    private int dfs(Node root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
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
