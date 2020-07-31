package Day2_Arrays;

public class NextPermutation {

    public boolean nextPermutation(int a[]) {
        int n = a.length, i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int idx = upperBound(a, i + 1, n - 1, a[i]);
        swap(a, i,  idx);
        reverse(a, i + 1, n - 1);
        return true;
    }

    public void reverse(int a[], int l, int r) {
        while (l < r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }
    public void swap(int a[], int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public int upperBound(int a[], int l, int r, int find) {
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (find >= a[mid]) r = mid - 1;
            else l = mid + 1;
        }
        return l - 1;
    }
}
