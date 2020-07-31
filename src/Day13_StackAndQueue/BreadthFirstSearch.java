package Day13_StackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public void bfs(List<Integer> graph[], int src, int n) {
        boolean vis[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        vis[src] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                int node = queue.poll();
                System.out.print(node + " ");
                for (int child : graph[node]) {
                    if (!vis[child]) {
                        queue.offer(child);
                        vis[child] = true;
                    }
                }
            }
            level++;
            System.out.println();
        }
        System.out.println("Total level is " + level);
    }
}
