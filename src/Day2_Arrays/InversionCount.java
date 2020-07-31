package Day2_Arrays;

import java.util.Arrays;

public class InversionCount {
    public void solve(int a[]) {
        int n = a.length;
        int ans = mergeSort(a, 0, n - 1);
        System.out.println(ans);
    }

    public int mergeSort(int a[], int l, int r) {
        int ans = 0;
        if (l >= r) return ans;
        int mid = (l + r) >> 1;
        ans += mergeSort(a, l, mid);
        ans += mergeSort(a, mid + 1, r);
        ans += merge(a, l, mid, r);
        return ans;
    }

    public int merge(int a[], int l, int mid, int r) {
        int left[] = Arrays.copyOfRange(a, l, mid + 1);
        int right[] = Arrays.copyOfRange(a, mid + 1, r + 1);
        int n = left.length, m = right.length, i = 0, j = 0, k = l, ans = 0;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
                ans += (mid + 1) - (l + i);
            }
        }
        while (i < n) { a[k++] = left[i++]; }
        while (j < m) { a[k++] = right[j++]; }
        return ans;
    }


}
