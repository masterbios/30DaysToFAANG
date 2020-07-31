package Day24_Graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DjikstraAlgorithm {

    final int INF = (1 << 29);

    public void solve(List<Pair> graph[], int n, int src) {

        boolean vis[] = new boolean[n];
        int dis[] = new int[n];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        Arrays.fill(dis, INF);

        q.offer(new Pair(src, 0));
        int cnt = n;
        dis[src] = 0;

        while (!q.isEmpty() && cnt > 0) {
            Pair cur = q.poll();
            int u = cur.node;
            if (vis[u]) continue;
            vis[u] = true;
            cnt--;
            for (Pair child : graph[u]) {
                int v = child.node, cost = child.cost;
                if (vis[v]) continue;
                if (dis[v] > dis[u] + cost) dis[v] = dis[u] + cost;
                q.offer(new Pair(v, dis[v]));
            }
        }

        System.out.println(Arrays.toString(dis));
    }


    class Pair implements Comparable<Pair> {
        int node, cost;

        public Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair that) {
            return this.cost - that.cost;
        }
    }
}
