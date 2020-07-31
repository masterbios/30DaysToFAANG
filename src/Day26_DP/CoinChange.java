package Day26_DP;

import java.util.Arrays;

public class CoinChange {
    final int INF = (1 << 29);

    public void solve(int coins, int changes[]) {
        int dp[] = new int[coins + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= coins; i++) {
            for (int x : changes) {
                if (i >= x) dp[i] = Math.min(dp[i], dp[i - x] + 1);
            }
        }
        System.out.println(dp[coins]);
    }
}
