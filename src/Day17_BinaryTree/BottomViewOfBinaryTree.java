package Day17_BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.*;

public class BottomViewOfBinaryTree {

    TreeMap<Integer, Pair> map1;
    TreeMap<Integer, Node> map2;

    public void solve(Node root) {
        this.map1 = new TreeMap<>();
        this.map2 = new TreeMap<>();

        recursive(root, 0, 0);
        for (Pair x : map1.values()) System.out.print(x.first.val + " ");

        iterative(root);
        for (Node x : map2.values()) System.out.print(x.val + " ");
    }

    // you have to keep track of level also and save the greater level node
    // map1<int, pair>
    public void recursive(Node root, int dis, int level) {
        if (root == null) return;
        if (!map1.containsKey(dis)) {
            map1.put(dis, new Pair(root, level));
        } else if (map1.containsKey(dis) && map1.get(dis).second <= level) {
            map1.put(dis, new Pair(root, level));
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
                map2.put(dis, cur);
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
