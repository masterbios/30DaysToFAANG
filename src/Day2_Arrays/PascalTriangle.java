package Day2_Arrays;

public class PascalTriangle {

    // a[i][j] = nCr


    public void solve(int len) {
        for (int n = 1; n <= len; n++) {
            int res = 1;
            for (int k = n; k < len; k++) System.out.print(" ");
            for (int r = 1; r <= n; r++) {
                System.out.print(res + " ");
                res = res * (n - r) / r;
            }
            System.out.println();
        }
    }

}
