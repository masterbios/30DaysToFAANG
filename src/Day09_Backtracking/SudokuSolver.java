package Day09_Backtracking;

import java.util.Arrays;

public class SudokuSolver {

    public void solve(int a[][], int n) {
        if (backtrack(a, n)) {
            for (int x[] : a) System.out.println(Arrays.toString(x));
        } else {
            System.out.println("Not possible");
        }
    }

    public boolean isSafe(int a[][], int n, int row, int col, int x) {
        for (int j = 0; j < n; j++) {
            if (a[row][j] == x) {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i][col] == x) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(n);
        int nx = row - row % sqrt;
        int ny = col - col % sqrt;

        for (int i = nx; i < nx + sqrt; i++) {
            for (int j = ny; j < ny + sqrt; j++) {
                if (a[i][j] == x) return false;
            }
        }
        return true;
    }

    public boolean backtrack(int a[][], int n) {
        int row = -1, col = -1;
        boolean isEmpty = true;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) return true;

        for (int x = 1; x <= n; x++) {
            if (isSafe(a, n, row, col, x)) {
                a[row][col] = x;
                if (backtrack(a, n)) return true;
                a[row][col] = 0;
            }
        }
        return false;
    }

}
