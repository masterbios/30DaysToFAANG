package Day23_Graph;

import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    boolean vis[];
    List<Integer> graph[];
    Stack<Integer> st;

    public void solve(List<Integer> graph[], int n) {
        this.vis = new boolean[n];
        this.graph = graph;
        this.st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) dfs(i);
        }

        while (!st.isEmpty()) System.out.print(st.pop() + " ");
        System.out.println();
    }

    private void dfs(int node) {
        vis[node] = true;
        for (int child : graph[node]) {
            if (!vis[child]) dfs(child);
        }
        st.push(node);
    }
}
