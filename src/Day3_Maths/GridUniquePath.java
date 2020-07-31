package Day3_Maths;

import java.util.Arrays;

public class GridUniquePath {

    public int solve(int a[][]) {
        int n = a.length, m = a[0].length;
        if (a[0][0] == 1 || a[n - 1][m - 1] == 1) return 0;
        int dp[][] = new int[n][m];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (a[0][i] != 1) dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            if (a[i][0] != 1) dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] == 1) continue;
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][m - 1];
    }
}
