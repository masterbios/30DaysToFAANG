package Day20_BST;

import Day19_BinaryTree.ConstructBinaryTreeFromPreorderAndInorder;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointer {

    public void solve(Node root) {
        Node cur = iterative(root);
    }

    public Node iterative(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size--> 0) {
                Node cur = q.poll();
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
                if (size >= 1) cur.next = q.peek();
            }
        }
        return root;
    }

    class Node {
        int val;
        Node left, right, next;
        public Node(int val) {
            this.val = val;
            this.left = this.right = this.next = null;
        }
    }
}
