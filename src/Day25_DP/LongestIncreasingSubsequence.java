package Day25_DP;

public class LongestIncreasingSubsequence {
    public void solve(int a[]) {
        System.out.println(solve1(a));
        System.out.println(solve2(a));
    }

    private int solve1(int a[]) {
        int n = a.length;
        int dp[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private int solve2(int a[]) {
        int n = a.length;
        int dp[] = new int[n];
        int ans = 1;
        for (int find : a) {
            int idx = upperBound(dp, 0, ans - 1, find);
            dp[idx] = find;
            if (ans == idx) ans++;
        }
        return ans;
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
