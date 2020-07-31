package Day22_MixedQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public void solve(int a[][], int x, int y, int color) {
        floodFill(a, x, y, color);
        for (int v[] : a) System.out.println(Arrays.toString(v));
    }

    private void floodFill(int a[][], int x, int y, int newcolor) {
        int dir[][] = {
                {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };

        int n = a.length, m = a[0].length;
        boolean vis[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{x, y});
        vis[x][y] = true;
        int oldcolor = a[x][y];
        a[x][y] = newcolor;

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dir[k][0] + cur[0], ny = dir[k][1] + cur[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m ||
                        vis[nx][ny] || a[nx][ny] != oldcolor) continue;
                vis[nx][ny] = true;
                a[nx][ny] = newcolor;
                q.offer(new int[]{nx, ny});
            }
        }

    }
}
