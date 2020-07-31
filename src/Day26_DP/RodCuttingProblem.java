package Day26_DP;

import java.util.Arrays;

public class RodCuttingProblem {

    final int INF = (1 << 29);

    public void solve(int price[], int length) {
        System.out.println(maxProfit(price, length));
    }

    private int maxProfit(int price[], int length) {
        int dp[] = new int[length + 1];
        Arrays.fill(dp, -INF);
        dp[0] = 0;
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + price[j - 1]);
            }
        }
        return dp[length];
    }
}
