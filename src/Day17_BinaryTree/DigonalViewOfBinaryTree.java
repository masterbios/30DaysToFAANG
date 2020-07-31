package Day17_BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DigonalViewOfBinaryTree {

    Map<Integer, List<Integer>> map;

    public void solve(Node root) {
        this.map = new HashMap<>();
        dfs(root, 0);
        for (List<Integer> nodes : map.values()) {
            System.out.println(nodes);
        }
    }

    private void dfs(Node root, int dis) {
        if (root == null) return;
        if (!map.containsKey(dis)) map.put(dis, new ArrayList<>());
        map.get(dis).add(root.val);
        dfs(root.left, dis + 1);
        dfs(root.right, dis);
    }

    public class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
}
