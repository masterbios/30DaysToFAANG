package Day23_Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CycleInDirectedGraph {

    List<Integer> graph[];

    Set<Integer> visited;
    Set<Integer> visiting;

    public void solve(List<Integer> graph[], int n) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.visiting = new HashSet<>();

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (isCyclic(i)) {
                flag = true;
                break;
            }
        }

        System.out.println(flag);
    }

    public boolean isCyclic(int node) {
        if (visited.contains(node)) return false;
        if (visiting.contains(node)) return true;

        visiting.add(node);
        visited.add(node);

        for (int child : graph[node]) {
            if (isCyclic(child)) return true;
        }

        visiting.remove(node);

        return false;
    }
}
