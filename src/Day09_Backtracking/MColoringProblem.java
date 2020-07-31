package Day09_Backtracking;

import java.util.Arrays;
import java.util.List;

public class MColoringProblem {
    int color[];
    List<Integer> graph[];
    int m, n;

    public void solve(List<Integer> graph[], int n, int m) {
        this.graph = graph;
        this.n = n;
        this.m = m;
        this.color = new int[n];
        if (dfs(0)) {
            System.out.println("Graph is m colorable");
            System.out.println(Arrays.toString(color));
        } else {
            System.out.println("Graph is not m colorable");
        }
    }

    public boolean dfs(int node) {
        if (node == n) return true;
        for (int next = 1; next <= m; next++) {
            if (isSafe(node, next)) {
                color[node] = next;
                if (dfs(node + 1)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int node, int c) {
        for (int child : graph[node]) {
            if (color[child] == c) return false;
        }
        return true;
    }
}
