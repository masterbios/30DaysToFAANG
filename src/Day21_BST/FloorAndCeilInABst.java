package Day21_BST;

public class FloorAndCeilInABst {


    public void solve(Node root, int key) {
        Node ceil = findCeil(root, key);
        Node floor = findFloor(root, key);

    }

    private Node findCeil(Node root, int key) {
        if (root == null) return root;
        if (root.val < key) return findCeil(root.right, key);
        else if (root.val == key) return root;
        Node ans = findCeil(root.left, key);
        if (ans == null) return ans = root;
        return ans.val >= key ? ans : root;
    }

    private Node findFloor(Node root, int key) {
        if (root == null) return root;
        if (root.val > key) return findFloor(root.left, key);
        else if (root.val == key) return root;
        Node ans = findFloor(root.right, key);
        if (ans == null) return ans = root;
        return ans.val >= key ? ans : root;
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
