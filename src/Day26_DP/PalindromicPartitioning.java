package Day26_DP;

import java.util.Arrays;

public class PalindromicPartitioning {

    final int INF = (1 << 29);

    public void solve(String s) {
        char a[] = s.toCharArray();
        System.out.println(go1(a));
        System.out.println(go2(a));
    }

    // good
    // time : O(n2)
    // space : O(n2)
    private int go2(char a[]) {
        int n = a.length;
        boolean isPal[][] = new boolean[n][n];
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) isPal[i][i] = true;
        for (int i = 0; i + 1 < n; i++) isPal[i][i + 1] = a[i] == a[i + 1];
        for (int size = 2; size < n; size++) {
            for (int l = 0; l + size < n; l++) {
                int r = l + size;
                isPal[l][r] = a[l] == a[r] && isPal[l + 1][r - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                continue;
            } else {
                dp[i] = i; // maxcut needed
                for (int j = 0; j < i; j++) {
                    if (isPal[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }

    // bad
    // time: O(n3)
    // space : O(n2)
    private int go1(char a[]) {
        int n = a.length;
        boolean isPal[][] = new boolean[n][n];
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            isPal[i][i] = true;
            dp[i][i] = 0;
        }

        for (int gap = 2; gap <= n; gap++) {
            for (int l = 0; l + gap - 1 < n; l++) {
                int r = l + gap - 1;

                if (gap == 2) {
                    isPal[l][r] = a[l] == a[r];
                } else {
                    isPal[l][r] = a[l] == a[r] && isPal[l + 1][r - 1];
                }

                if (isPal[l][r]) {
                    dp[l][r] = 0;
                } else {
                    dp[l][r] = INF;
                    for (int k = l; k < r; k++) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + 1);
                    }
                }

            }
        }

        return dp[0][n - 1];
    }
}
