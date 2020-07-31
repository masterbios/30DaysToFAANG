package Day26_DP;

public class SubsetSum {

    public void solve(int a[]) {
        System.out.println(isPossible(a));
    }

    private boolean isPossible(int a[]) {
        int n = a.length, sum = 0;
        for (int x : a) sum += x;
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= a[i - 1]) dp[i][j] |= dp[i - 1][j - a[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
