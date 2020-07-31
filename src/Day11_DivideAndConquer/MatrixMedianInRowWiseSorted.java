package Day11_DivideAndConquer;

public class MatrixMedianInRowWiseSorted {

    // the numbers will be max of 32 bit,
    // so binary search of numbers from min to max
    // will be performed in at most 32
    // Time Complexity: O(32 * r * log(c))
    // Space Complexity : O(1)

    public void solve(int a[][]) {
        int r = a.length, c = a[0].length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            low = Math.min(low, a[i][0]);
            high = Math.max(high, a[i][c - 1]);
        }
        int median = (r * c + 1) / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int i = 0; i < r; i++) {
                cnt += upperBound(a[i], mid);
            }
            System.out.println("mid=" + mid + " cnt=" + cnt);
            if (cnt < median) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(low - 1);
    }

    public int upperBound(int a[], int find) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < find) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
