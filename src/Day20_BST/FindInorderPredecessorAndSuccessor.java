package Day20_BST;

public class FindInorderPredecessorAndSuccessor {

    public void solve(Node root, int key) {

    }
    Node pre, suc;
    public void recursive(Node root, int key) {
        if (root == null) return;
        if (root.val == key) {
            if (root.left != null) {
                Node cur = root.left;
                while (cur.right != null) {
                    cur = cur.right;
                }
                pre = cur;
            }
            if (root.right != null) {
                Node cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                suc = cur;
            }
            return;
        }

        if (key < root.val) {
            suc = root;
            recursive(root.left, key);
        } else {
            pre = root;
            recursive(root.right, key);
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
