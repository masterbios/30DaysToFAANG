package Day20_BST;

public class LCA {

    public void solve(Node root, Node first, Node second) {
        Node ans = lca(root, first,second);
    }

    private Node lca(Node root, Node first, Node second) {
        if (root == null) return null;
        if (root.val < first.val && root.val < second.val) {
            return lca(root.right, first, second);
        } else if (root.val > first.val && root.val > second.val) {
            return lca(root.left, first, second);
        } else {
            return root;
        }
    }

    class Node {
        int val;
        Node left,right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
