package Day01_Arrays;

public class KadaneAlgo {
    public int solve(int a[]) {
        int n = a.length, maxsofar = a[0], curmax = a[0];
        for (int i = 1; i < n; i++) {
            curmax = Math.max(a[i], curmax + a[i]);
            maxsofar = Math.max(maxsofar, curmax);
        }
        return maxsofar;
    }
}
