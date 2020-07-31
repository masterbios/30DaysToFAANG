package Day19_BinaryTree;

public class FlattenBinaryTreeToLinkedList {

    public void solve(Node root) {
        flatten(root);
    }

    private void flatten(Node root) {
        if (root == null) return;
        Node left = root.left, right = root.right;
        root.left = root.right = null;
        flatten(left);
        flatten(right);
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
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
