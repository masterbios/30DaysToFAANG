package Day23_Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    int dir[][] = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    int n, m;
    public void solve(int a[][]) {
        int ans = 0;
        this.n = a.length;
        this.m = a[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    ans++;
                    bfs(a, i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private void bfs(int a[][], int x, int  y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        a[x][y] = 0;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dir[k][0] + cur[0], ny = dir[k][1] + cur[1];
                if (nx < 0 || nx >= n|| ny < 0 || ny >= m || a[nx][ny] == 0) continue;
                a[nx][ny] = 0;
                q.offer(new int[]{nx, ny});
            }
        }

    }
}
