package Day19_BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {

    public void solve(int pre[], int in[]) {
        Node root = recursive(pre, in);
    }

    int idx;
    Map<Integer, Integer> map;
    public Node recursive(int pre[], int in[]) {
        this.idx = 0;
        this.map = new HashMap<>();
        int n = in.length - 1;
        for (int i = 0; i < in.length; i++) map.put(in[i], i);
        return recursive(pre, in, 0, n);
    }
    public Node recursive(int pre[], int in[], int l, int r) {
        if (l > r) return null;
        int data = pre[idx++];
        Node root = new Node(data);
        if (l == r) return root;
        int mid = map.get(data);
        root.left = recursive(pre, in, l, mid - 1);
        root.right = recursive(pre, in, mid + 1, r);
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
