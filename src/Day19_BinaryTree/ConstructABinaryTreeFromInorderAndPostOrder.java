package Day19_BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructABinaryTreeFromInorderAndPostOrder {

    public void solve(int in[], int po[]) {
        Node root = recursive(in, po);
    }

    Map<Integer, Integer> map;
    int idx;

    private Node recursive(int in[], int po[]) {
        int n = po.length;
        this.idx = n - 1;
        this.map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(in[i], i);
        return recursive(in, po, 0, n - 1);
    }

    private Node recursive(int in[], int po[], int l, int r) {
        if (l > r) return null;
        int data = po[idx--];
        Node root = new Node(data);
        if (l == r) return root;
        int mid = map.get(data);
        root.right = recursive(in, po, mid + 1, r);
        root.left = recursive(in, po, l, mid - 1);
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
