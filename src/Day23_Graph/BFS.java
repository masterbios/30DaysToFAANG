package Day23_Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    boolean vis[];
    List<Integer> graph[];

    public void solve(List<Integer> graph[], int n) {
        this.vis = new boolean[n];
        this.graph = graph;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) bfs(i);
        }
    }

    private void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int child : graph[u]) {
                if (!vis[child]) {
                    vis[child] = true;
                    q.offer(child);
                }
            }
        }
    }

}
