package Day24_Graph;

import java.util.Arrays;

public class FlyodWarshall {
    final int INF = (1 << 29);

    public void solve(int edge[][], int n, int src) {
        int dis[][] = new int[n][n];
        for (int x[] : dis) Arrays.fill(x, INF);
        for (int x[] : edge) {
            int u = x[0], v = x[1], cost = x[2];
            dis[u][v] = Math.min(dis[u][v], cost);
        }
        dis[src][src] = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

    }
}
