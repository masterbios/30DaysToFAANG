package Day11_DivideAndConquer;

public class KthElementOfTwoSortedArrays {

    public void solve(int a[], int b[], int k) {
        System.out.println(mergeTechnique(a, b, k));
        System.out.println(divide(a, b, k));
    }

    // Merge sort merging routine
    // Time : O(K)
    // Space : O(1);
    public int mergeTechnique(int a[], int b[], int k) {
        int n = a.length, m = b.length, i = 0, j = 0, cnt = 0;
        if (n + m < k) return -1;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                cnt++;
                if (cnt == k) return a[i];
                i++;
            } else {
                cnt++;
                if (cnt == k) return b[j];
                j++;
            }
        }
        while (i < n) {
            cnt++;
            if (cnt == k) return a[i];
            i++;
        }
        while (j < m) {
            cnt++;
            if (cnt == k) return b[j];
            j++;
        }
        return -1;
    }

    // Time : O(logn + logm)
    public int divide(int a[], int b[], int k) {
        return divide(a, b, 0, a.length, 0, b.length, k - 1);
    }

    public int divide(int a[], int b[], int s1, int e1, int s2, int e2, int k) {
        if (s1 == e1) return b[k];
        if (s2 == e2) return a[k];
        int mid1 = (e1 - s1) / 2, mid2 = (e2 - s2) / 2;
        if (mid1 + mid2 < k) {
            if (a[mid1] > b[mid2]) {
                return divide(a, b, s1, e1, s2 + mid2 + 1, e2, k - mid2 - 1);
            } else {
                return divide(a, b, s1 + mid1 + 1, e1, s2, e2, k - mid1 - 1);
            }
        } else { // mid1  + mid2 > k
            if (a[mid1] > b[mid2]) {
                return divide(a, b, s1, s1 + mid1, s2, e2, k);
            } else {
                return divide(a, b, s1, e1, s2, s2 + mid2, k);
            }
        }
    }
}
