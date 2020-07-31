package Day09_Backtracking;

import java.util.Arrays;

public class RatInAMaze {

    // 0->don't use, 1-> use
    int dir[][] = {
            {0, 1}, {1, 0}
    };
    int sol[][], a[][];
    int r, c;

    public void solve(int a[][]) {
        this.a = a;
        this.r = a.length;
        this.c = a[0].length;
        this.sol = new int[r][c];
        if (a[0][0] != 0 && dfs(0, 0)) {
            System.out.println("Solution exists");
            for (int x[] : sol) System.out.println(Arrays.toString(x));
        } else {
            System.out.println("Solution doesn't exists");
        }
    }

    public boolean dfs(int i, int j) {
        if (i == r - 1 && j == c - 1) {
            if (a[i][j] != 0) {
                sol[i][j] = 1;
                return true;
            } else {
                return false;
            }
        }
        sol[i][j] = 1;
        for (int k = 0; k < dir.length; k++) {
            int nx = i + dir[k][0], ny = j + dir[k][1];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || a[nx][ny] == 0) continue;
            if (dfs(nx, ny)) return true;
        }
        sol[i][j] = 0;
        return false;
    }
}
