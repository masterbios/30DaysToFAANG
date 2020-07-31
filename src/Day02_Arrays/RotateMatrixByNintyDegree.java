package Day02_Arrays;

public class RotateMatrixByNintyDegree {
    public void solve(int[][] a) {
        if (a == null || a.length < 1) return;
        int r = a.length, c = a[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < r; i++) {
            int x = 0, y = c - 1;
            while (x < y) {
                int temp = a[i][y];
                a[i][y] = a[i][x];
                a[i][x] = temp;
                x++; y--;
            }
        }
    }
}
