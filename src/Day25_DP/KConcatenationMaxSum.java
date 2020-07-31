package Day25_DP;

public class KConcatenationMaxSum {


    class Solution {

        // https://leetcode.com/problems/k-concatenation-maximum-sum/

        final long mod = (long) (1e9) + 7L;

        public void solve(int a[], int k) {
            System.out.println(kConcatenationMaxSum(a, k));
        }

        // case 1 : sum * k
        // case 2 : simple kadanes
        // case 3 : (a) sum > 0 then (maxprefix + maxsuffix + (k - 2) * sum)
        //          (b) sum < 0 maxprefix + maxsuffix
        // max(case1, case2, case3, 0)

        private int kConcatenationMaxSum(int[] a, int k1) {
            int n = a.length, sum = 0;
            long max1 = 0, max2 = 0, max3 = 0, k = k1;
            long maxpre = maxprefix(a), maxsuf = maxsuffix(a);
            for (int i = 0; i < n; i++) sum += a[i];
            max1 = Math.max(0, kadane(a) % mod);
            max2 = (sum * k) % mod;
            if (sum > 0) {
                max3 = (maxpre + maxsuf) % mod;
                long nxt = ((k - 2) * sum) % mod;
                max3 = (max3 + nxt) % mod;
            } else {
                max3 = (maxpre + maxsuf) % mod;
            }
            return (int) Math.max(max1, Math.max(max2, max3));
        }

        private long kadane(int a[]) {
            long curmax = a[0], maxsofar = a[0];
            int n = a.length;
            for (int i = 1; i < n; i++) {
                curmax = Math.max(curmax + a[i], a[i]);
                curmax %= mod;
                maxsofar = Math.max(maxsofar, curmax);
            }
            return maxsofar;
        }

        private long maxprefix(int a[]) {
            long curmax = a[0], maxsofar = a[0];
            int n = a.length;
            for (int i = 1; i < n; i++) {
                curmax = (curmax + a[i]) % mod;
                maxsofar = Math.max(maxsofar, curmax);
            }
            return maxsofar;
        }

        private long maxsuffix(int a[]) {
            int n = a.length;
            long curmax = a[n - 1], maxsofar = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                curmax = (curmax + a[i]) % mod;
                maxsofar = Math.max(maxsofar, curmax);
            }
            return maxsofar;
        }

    }

}
