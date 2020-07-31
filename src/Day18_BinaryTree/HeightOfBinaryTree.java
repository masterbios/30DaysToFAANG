package Day18_BinaryTree;

public class HeightOfBinaryTree {

    public void solve(Node root) {
        System.out.println(dfs(root));
    }

    public int dfs(Node root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
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
