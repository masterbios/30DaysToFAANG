package Day17_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    TreeMap<Integer, Node> map;
    TreeMap<Integer, Pair> map2;

    public void solve(Node root) {
        this.map = new TreeMap<>();
        this.map2 = new TreeMap<>();

        recursive(root, 0, 0);
        for (Pair x : map2.values()) System.out.print(x.first.val + " ");


        iterative(root);
        for (Node x : map.values()) System.out.print(x.val + " ");
    }

    // also track level and store level with less value
    // map2<int, pair>
    public void recursive(Node root, int dis, int level) {
        if (root == null) return;
        if (!map2.containsKey(dis)) {
            map2.put(dis, new Pair(root, level));
        } else if (map2.containsKey(dis) && map2.get(dis).second > level) {
            map2.put(dis, new Pair(root, level));
        }
        recursive(root.left, dis - 1, level + 1);
        recursive(root.right, dis + 1, level + 1);
    }

    public void iterative(Node root) {
        if (root == null) return;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.peek().first;
                int dis = q.peek().second;
                q.poll();
                if (!map.containsKey(dis)) map.put(dis, cur);
                if (cur.left != null) q.offer(new Pair(cur.left, dis - 1));
                if (cur.right != null) q.offer(new Pair(cur.right, dis + 1));
            }
        }
    }

    class Pair {
        Node first;
        int second;
        public Pair(Node first, int second) {
            this.first = first;
            this.second = second;
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
