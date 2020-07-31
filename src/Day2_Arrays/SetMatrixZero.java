package Day2_Arrays;

public class SetMatrixZero {
    public void solve(int a[][]) {
        int r = a.length, c = a[0].length;
        boolean isZero = false;
        for (int i = 0; i < r; i++) {
            if (a[i][0] == 0) isZero = true;
            for (int j = 1; j < c; j++) {
                if (a[i][j] == 0) a[i][0] = a[0][j] = 0;
            }
        }
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 1; j--) {
                if (a[i][0] == 0 || a[0][j] == 0) a[i][j] = 0;
            }
            if (isZero) a[i][0] = 0;
        }
    }
}
