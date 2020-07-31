package Day11_DivideAndConquer;

public class MedianOfTwoSortedArrays {

    final int max = Integer.MAX_VALUE;
    final int min = Integer.MIN_VALUE;

    public void solve(int a[], int b[]) {
        System.out.println(go(a, b));
    }

    private double go(int a[], int b[]) {
        int n = a.length, m = b.length;
        if (n < m) return go(b, a);
        int low = 0, high = m * 2;
        while (low <= high) {
            int mid2 = low + (high - low) / 2;
            int mid1 = (n + m) - mid2;

            double l1 = mid1 == 0 ? min : a[(mid1 - 1) / 2];
            double r1 = mid1 == n * 2 ? max : a[mid1 / 2];
            double l2 = mid2 == 0 ? min : b[(mid2 - 1) / 2];
            double r2 = mid2 == m * 2 ? max : b[mid2 / 2];

            if (l1 > r2) {
                low = mid2 + 1;
            } else if (r1 > l2) {
                high = mid2 - 1;
            } else {
                double ans = Math.max(l1, l2) + Math.min(r1, r2);
                return ans / 2.0d;
            }
        }
        return -1;
    }
}
