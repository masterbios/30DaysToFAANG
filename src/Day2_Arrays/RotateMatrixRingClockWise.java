package Day2_Arrays;

import java.util.Arrays;

public class RotateMatrixRingClockWise {

    public void solve(int a[][]) {
        int n = a.length, m = a[0].length;
        int row = 0, col = 0, prev = 0, cur = 0;
        while (row < n || col < m) {
            if (row + 1 == n || col + 1 == m) break;
            prev = a[row + 1][col];
            for (int i = col; i < m; i++) {
                cur = a[row][i];
                a[row][i] = prev;
                prev = cur;
            }
            row++;
            for (int i = row; i < n; i++) {
                cur = a[i][m - 1];
                a[i][m - 1] = prev;
                prev = cur;
            }
            m--;
            if (row < n) {
                for (int i = m - 1; i >= col; i--) {
                    cur = a[n - 1][i];
                    a[n - 1][i] = prev;
                    prev = cur;
                }
            }
            n--;
            if (col < m) {
                for (int i = n - 1; i >= row; i--) {
                    cur = a[i][col];
                    a[i][col] = prev;
                    prev = cur;
                }
            }
            col++;
        }
        System.out.println(Arrays.deepToString(a));
    }
}
