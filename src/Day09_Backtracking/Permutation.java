package Day09_Backtracking;

import java.util.Arrays;

public class Permutation {
    public void solve(int a[]) {
        solve(a, 0, a.length - 1);
    }

    public void solve(int a[], int l, int r) {
        if (l == r) {
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = l; i <= r; i++) {
                swap(a, l, i);
                solve(a, l + 1, r);
                swap(a, l, i);
            }
        }
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
