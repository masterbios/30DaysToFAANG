package Day25_DP;

public class ZeroOneKnapsack {

    public void solve(int wt[], int val[], int weight) {
        int n = wt.length;
        int dp[][] = new int[n + 1][weight + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= weight; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= wt[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        System.out.println(dp[n][weight]);
    }
}
