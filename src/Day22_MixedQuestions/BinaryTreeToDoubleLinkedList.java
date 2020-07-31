package Day22_MixedQuestions;

import java.util.Stack;

public class BinaryTreeToDoubleLinkedList {

    public void solve(Node root) {
        // head contains answer
    }

    Node head, prev;

    private void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        dfs(root.right);
    }


    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }


}
