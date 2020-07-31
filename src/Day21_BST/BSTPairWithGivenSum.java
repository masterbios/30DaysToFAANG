package Day21_BST;

import java.util.*;

public class BSTPairWithGivenSum {

    public void solve(Node root, int sum) {

    }

    Set<Integer> set = new HashSet<>();

    public boolean recursive(Node root, int sum) {
        if (root == null) return false;
        if (recursive(root.left, sum)) return true;
        if (set.contains(sum - root.val)) return true;
        else set.add(root.val);
        return recursive(root.right, sum);
    }


    public boolean iterative(Node root, int sum) {
        if (root == null) return false;
        Stack<Node> l = new Stack<>();
        Stack<Node> r = new Stack<>();

        Node cur = root;
        while (cur != null) {
            l.push(cur);
            cur = cur.left;
        }

        cur = root;
        while (cur != null) {
            r.push(cur);
            cur = cur.right;
        }

        while (l.peek() != r.peek()) {
            int v1 = l.peek().val, v2 = r.peek().val;
            if (v1 + v2 == sum) return true;
            else if (v1 + v2 < sum) {
                cur = l.pop();
                cur = cur.right;
                while (cur != null) {
                    l.push(cur);
                    cur = cur.left;
                }
            } else {
                cur = r.pop();
                cur = cur.left;
                while (cur != null) {
                    r.push(cur);
                    cur = cur.right;
                }
            }
        }

        return false;
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
