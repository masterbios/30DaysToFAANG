package Day23_Graph;

import java.util.*;

public class CloneAGraph {

    public void solve(Node node) {
        Node clone1 = bfsCloneGraph(node);
        Node clone2 = dfsCloneGraph(node);
    }

    private Node bfsCloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.offer(node);
        map.put(node.val, new Node(node.val, new ArrayList<>()));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<>()));
                    q.offer(neighbor);
                }
                map.get(cur.val).neighbors.add(map.get(neighbor.val));
            }
        }

        return map.get(node.val);
    }

    Map<Integer, Node> map = new HashMap<>();
    private Node dfsCloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) return map.get(node.val);

        Node cur = new Node(node.val, new ArrayList<>());
        map.put(cur.val, cur);

        for (Node neighbor : node.neighbors) {
            cur.neighbors.add(dfsCloneGraph(neighbor));
        }

        return map.get(node.val);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
