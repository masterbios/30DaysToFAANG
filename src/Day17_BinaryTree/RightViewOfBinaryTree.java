package Day17_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBinaryTree {

    int maxdepth = -1;
    public void recursive(Node root, int depth) {
        if (root == null) return;
        if (depth > maxdepth) {
            maxdepth = depth;
            System.out.print(root.val + " ");
        }
        recursive(root.right, depth + 1);
        recursive(root.left, depth + 1);
    }

    public void iterative(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == size - 1) {
                    System.out.print(cur.val + " ");
                }
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
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
