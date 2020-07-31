package Day07_TwoPointers;

public class RemoveDuplicateFromSortedArray {

    public void solve2(int a[]) {
        int n = a.length, j = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (a[i] != a[i + 1]) a[j++] = a[i];
        }
        a[j++] = a[n - 1];
        for (int i = 0; i < j; i++) System.out.print(a[i] + " ");
        System.out.println();
    }


    public void solve1(int a[]) {
        int n = a.length, prev = 0, idx = 0;
        while (idx < n) {
            a[prev++] = a[idx];
            idx = upperBound(a, idx + 1, n - 1, a[idx]);
            if (idx >= n) break;
        }
        for (int i = 0; i < prev; i++) System.out.print(a[i] + " ");
        System.out.println();
    }

    public int upperBound(int a[], int l, int r, int find) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (a[mid] <= find) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
