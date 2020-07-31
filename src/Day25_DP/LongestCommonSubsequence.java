package Day25_DP;

public class LongestCommonSubsequence {

    public void solve(String a, String b) {
        System.out.println(go(a.toCharArray(), b.toCharArray()));
    }

    private int go(char a[], char b[]) {
        int n = a.length, m = b.length;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        int x = n, y = m;
        StringBuilder sb = new StringBuilder();
        while (x > 0 && y > 0) {
            if (a[x - 1] == b[y - 1]) {
                sb.append(a[x - 1]);
                x--; y--;
            } else if (dp[x - 1][y] > dp[x][y - 1]) {
                x--;
            } else {
                y--;
            }
        }
        sb.reverse();
        System.out.println(sb.toString());
        return dp[n][m];
    }
}
