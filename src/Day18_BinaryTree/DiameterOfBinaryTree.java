package Day18_BinaryTree;

public class DiameterOfBinaryTree {

    int ans;
    public void solve(Node root) {
        this.ans = 0;
    }

    // Time : O(n)
    // space : O(h)
    public int dfs2(Node root, Height h) {
        if (root == null) return 0;
        Height left = new Height(0);
        Height right = new Height(0);
        int leftdiameter = dfs2(root.left, left);
        int rightdiameter = dfs2(root.right, right);
        h.h = Math.max(left.h, right.h) + 1;
        return Math.max(left.h + right.h + 1, Math.max(left.h, right.h));
    }

    // better and neat
    // Time : O(n)
    // space : O(h)
    public int dfs1(Node root) {
        if (root == null) return 0;
        int left = dfs1(root.left);
        int right = dfs1(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }

    class Height {
        int h;
        public Height(int h) {
            this.h = h;
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
