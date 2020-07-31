package Day24_Graph;

import java.util.Arrays;

public class BellmanFord {

    // single source shortest path algo
    // works also with the negative cycle
    // g[0] = u, g[1] = v, g[2] = wt

    // time complexity : O(V + E)
    // space complexity : O(V)
    final int INF = (1 << 29);

    public void solve(int edges[][], int n, int src) {
        int dis[] = new int[n];
        Arrays.fill(dis, INF);
        dis[src] = 0;

        for (int i = 1; i < n; i++) {
            for (int x[] : edges) {
                int u = x[0], v = x[1] - 1, cost = x[2];
                if (dis[u] != INF && dis[v] > dis[u] + cost) {
                    dis[v] = dis[u] + cost;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int x[] : edges) {
                int u = x[0] - 1, v = x[1] - 1, cost = x[2];
                if (dis[u] != INF && dis[v] > dis[u] + cost) {
                    System.out.println("Graph contains negative cycle");
                    return;
                }
            }
        }

        System.out.println(Arrays.toString(dis));

    }
}
