package Day09_Backtracking;

import java.util.Arrays;

// time complexity : O(N!)
// space complextiy : O(N)

public class NQueenProblem {
    int a[][], n;

    public void solve(int n) {
        this.n = n;
        this.a = new int[n][n];
        if (backtrack(0)) {
            for (int x[] : a) System.out.println(Arrays.toString(x));
        } else {
            System.out.println("Not possible");
        }
    }

    public boolean backtrack(int col) {
        if (col >= n) return true;
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col)) {
                a[row][col] = 1;
                if (backtrack(col + 1)) return true;
                a[row][col] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int row, int col) {
        for (int j = 0; j < col; j++) {
            if (a[row][j] == 1) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; j--, i--) {
            if (a[i][j] == 1) return false;
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (a[i][j] == 1) return false;
        }
        return true;
    }
}
