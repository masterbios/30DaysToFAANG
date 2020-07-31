package Day23_Graph;

import java.util.List;

public class DFS {
    boolean vis[];
    List<Integer> graph[];

    public void solve(List<Integer> graph[], int n) {
        this.vis = new boolean[n];
        this.graph = graph;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i);
        }
    }

    private void dfs(int node) {
        vis[node] = true;
        for (int child : graph[node]) {
            if (!vis[child]) dfs(child);
        }
    }
}
