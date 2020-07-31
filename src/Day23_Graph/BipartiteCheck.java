package Day23_Graph;

import java.util.Arrays;
import java.util.List;

public class BipartiteCheck {

    List<Integer> graph[];
    int color[];

    public void solve(List<Integer> graph[], int n) {
        this.color = new int[n];
        this.graph = graph;
        boolean flag = true;

        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 1;
                if (!dfs(i)) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println(flag);
    }

    private boolean dfs(int node) {
        for (int child : graph[node]) {
            if (color[child] == -1) {
                color[child] = color[node] == 1 ? 2 : 1;
                if (!dfs(child)) return false;
            } else if (color[child] == color[node]) {
                return false;
            }
        }
        return true;
    }

}
