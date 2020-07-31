package Day25_DP;

public class MaxCircularSubarraySum {

    public void solve(int a[]) {
        System.out.println(go(a));
    }

    // find maxsubarray and minsubarray ans = (maxsubarray, total - minsubarray)
    // if maxsubarray is less than zero that means all elements are negative return maxsubarray
    private int go(int a[]) {
        int n = a.length;
        int maxsofar = Integer.MIN_VALUE;
        int minsofar = Integer.MAX_VALUE;
        int curmin = 0, curmax = 0, total = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            curmax = Math.max(curmax + a[i], a[i]);
            curmin = Math.min(curmin + a[i], a[i]);
            maxsofar = Math.max(maxsofar, curmax);
            minsofar = Math.min(minsofar, curmin);
            total += a[i];
        }

        if (maxsofar > 0) {
            ans = Math.max(maxsofar, total - minsofar);
        } else {
            ans = maxsofar;
        }
        return ans;
    }
}
