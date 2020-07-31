package Day21_BST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(Node root) {
        if (root == null) return "null";
        String ans = "" + root.val + ",";
        ans += serialize(root.left) + ",";
        ans += serialize(root.right);
        return ans;
    }

    public Node deserialize(String s) {
        Queue<String> q = new LinkedList<>();
        String input[] = s.split(",");
        q.addAll(Arrays.asList(input));
        return deserialize(q);
    }

    public Node deserialize(Queue<String> q) {
        if (q.isEmpty()) return null;
        if (q.peek().equals("null")) {
            q.poll();
            return null;
        }
        int val = Integer.parseInt(q.poll());
        Node root = new Node(val);
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
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
