package Day10;

import java.util.Arrays;

// Paritition in two subsets

public class SubsetSum1 {
    public void solve(int a[], int target) {
        int n = a.length;
        boolean dp[][] = new boolean[n + 1][target + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - a[i - 1]];
                }
            }
        }
        System.out.println(dp[n + 1][target]);
    }
}
