package Day18_BinaryTree;

public class CheckIfBinaryTreeIsHeightBalanced {

    boolean isBalanced;
    public void solve(Node root) {
        this.isBalanced = true;
        dfs(root);
        System.out.println(this.isBalanced);
    }

    public int dfs(Node root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int diff = Math.abs(right - left);
        if (diff > 1) this.isBalanced = false;
        return Math.max(left, right) + 1;
    }

    // gfg way
    public boolean dfs1(Node root, Height height) {
        if (root == null) return true;
        Height left = new Height(0);
        Height right = new Height(0);
        boolean leftb = dfs1(root.left, left);
        boolean rightb = dfs1(root.right, right);
        height.h = Math.max(left.h, right.h) + 1;
        if (Math.abs(left.h - right.h) > 1) return false;
        return (leftb && rightb);
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
