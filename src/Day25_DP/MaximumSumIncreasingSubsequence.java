package Day25_DP;

import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

    public void solve(int a[]) {
        System.out.println(Arrays.toString(a));
        System.out.println(go1(a) + " " + go2(a));
    }

    private int go2(int a[]) {
        int n = a.length;
        int dp[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) dp[i] = a[i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + a[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // doesn't work
    private int go1(int a[]) {
        int n = a.length, ans = 0;
        int dp[] = new int[n];
        int cursum = 0, max = 0;
        for (int find : a) {
            int idx = upperBound(dp, 0, ans - 1, find);
            cursum -= dp[idx];
            dp[idx] = find;
            cursum += dp[idx];
            max = Math.max(cursum, max);
            if (idx == ans) ans++;
        }
//        System.out.println(Arrays.toString(dp));
        return max;
    }

    public int upperBound(int a[], int low, int high, int find) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < find) low = mid + 1;
            else if (a[mid] == find) return mid;
            else high = mid - 1;
        }
        return low;
    }
}
