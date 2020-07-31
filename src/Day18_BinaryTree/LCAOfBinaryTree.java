package Day18_BinaryTree;

public class LCAOfBinaryTree {

    public void solve(Node root, Node v1, Node v2) {
        System.out.println(go(root, v1, v2));
    }

    // first check if both values present or not
    boolean first, second;

    private Node go(Node root, Node v1, Node v2) {
        first = second = false;
        return dfs(root, v1, v2);
    }

    private Node dfs(Node root, Node v1, Node v2) {
        if (root == null) return null;
        if (root == v1) {
            first = true;
            return root;
        }
        if (root == v2) {
            second = true;
            return root;
        }
        Node left = dfs(root.left, v1, v2);
        Node right = dfs(root.right, v1, v2);
        if (left != null && right != null) return root;
        return left == null ? right : left;
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
