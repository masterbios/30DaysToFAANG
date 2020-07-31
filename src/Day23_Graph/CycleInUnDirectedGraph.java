package Day23_Graph;

import java.util.List;

public class CycleInUnDirectedGraph {

    boolean vis[];
    List<Integer> graph[];

    public void solve(List<Integer> graph[], int n) {
        this.vis = new boolean[n];
        this.graph = graph;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                if (isCycle(i, -1)) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag);
    }

    private boolean isCycle(int node, int par) {
        vis[node] = true;
        for (int child : graph[node]) {
            if (!vis[child]) {
                if (isCycle(child, node)) return true;
            } else if (child != par) {
                return true;
            }
        }
        return false;
    }

}
