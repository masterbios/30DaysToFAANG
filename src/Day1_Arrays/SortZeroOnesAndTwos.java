package Day1_Arrays;

public class SortZeroOnesAndTwos {
    // [0,1,0,2,2,0,1,1,0]
    public void solve(int a[]) {
        if (a == null || a.length == 0) return;
        int n = a.length, zero = -1, one = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                zero++;
                swap(a, i, zero);
            }
            if (a[i] == 1) {
                one = (one == -1) ? zero : one;
                one++;
                swap(a, i, one);
            }
        }
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
