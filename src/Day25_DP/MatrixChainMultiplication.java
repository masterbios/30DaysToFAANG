package Day25_DP;

public class MatrixChainMultiplication {

    final int INF = (1 << 29);

    public void solve(int a[]) {
        System.out.println(go(a));
    }

    private int go(int a[]) {
        int n = a.length;
        int dp[][] = new int[n][n];
        for (int size = 2; size < n; size++) {
            for (int l = 0; l + size < n; l++) {
                int r = l + size;
                dp[l][r] = INF;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + a[l] * a[k] * a[r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
