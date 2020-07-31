package Day2_Arrays;

public class BuyAndSellStockWithKTransactions {
    public int solve(int prices[], int k) {
        int n = prices.length;
        int dp[][] = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int max = -prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j]);
                max = Math.max(max, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }
}
