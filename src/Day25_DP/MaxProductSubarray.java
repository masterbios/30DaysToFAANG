package Day25_DP;

public class MaxProductSubarray {

    public void solve(int a[]) {
        int ans = go(a);
    }

    private int go(int a[]) {
        int ans = a[0], min = a[0], max = a[0];
        for (int i = 1; i < a.length; i++) {
            int curmin = min(a[i], min * a[i], max * a[i]);
            int curmax = max(a[i], min * a[i], max * a[i]);
            ans = Math.max(ans, curmax);
            min = curmin;
            max = curmax;
        }
        return ans;
    }

    private int min(int ...a) {
        int min = Integer.MAX_VALUE;
        for (int x : a) min = Math.min(min, x);
        return min;
    }


    private int max(int ...a) {
        int max = Integer.MIN_VALUE;
        for (int x : a) max = Math.max(max, x);
        return max;
    }
}
