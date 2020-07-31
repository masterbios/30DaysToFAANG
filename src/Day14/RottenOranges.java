package Day14;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    int dir[][] = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
    };

    public void solve(int a[][]) {
        int ans = bfs(a);
        if (ans == -1) {
            System.out.println("All oranges will not rot");
        } else {
            System.out.println("All oranges will rot in " + ans);
        }
    }

    private int bfs(int a[][]) {
        int r = a.length, c = a[0].length, good = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (a[i][j] == 1) {
                    good++;
                }
            }
        }

        if (good == 0) return 0;
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                int cur[] = q.poll();
                int x = cur[0], y = cur[1];
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || nx >= r || ny < 0 || ny >= c || a[nx][ny] != 1) continue;
                    a[nx][ny] = 2;
                    good--;
                    q.offer(new int[]{nx, ny});
                }
            }
            ans++;
            if (good == 0) break;
        }

        return good == 0 ? ans : -1;
    }
}
