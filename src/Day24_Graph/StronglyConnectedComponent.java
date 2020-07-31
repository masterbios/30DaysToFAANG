package Day24_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {

    int n, scc;
    boolean vis[];
    Stack<Integer> st;
    List<Integer> graph[];

    public void solve(List<Integer> graph[], int n) {

        this.n = n;
        this.scc = 0;
        this.graph = graph;
        this.st = new Stack<>();
        this.vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i, true);
        }

        Arrays.fill(vis, false);
        this.graph = reverseGraph();

        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node]) continue;
            dfs(node, false);
            this.scc++;
        }

        System.out.println(this.scc);
    }


    private void dfs(int node, boolean fillstack) {
        vis[node] = true;
        for (int child : graph[node]) {
            if (vis[child]) continue;
            dfs(child, fillstack);
        }
        if (fillstack) st.push(node);
    }


    private List<Integer>[] reverseGraph() {
        List<Integer> rev[] = new ArrayList[this.n];
        for (int i = 0; i < n; i++) rev[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 0) continue;
            int v = i;
            for (int u : graph[i]) {
                rev[u].add(v);
            }
        }
        return rev;
    }
}
