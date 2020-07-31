package Day1_Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrayWithoutExtraSpace {

    // bad time : O(n * m)
    public void solve(int a[], int b[]) {
        int n = a.length, m = b.length;
        for (int i = m - 1; i >= 0; i--) { // b
            int last = a[n - 1], j = n - 2;
            for ( ; j >= 0 && a[j] > b[i]; j--) { // a
                a[j + 1] = a[j];
            }
            if (j != n - 2 || last > b[i]) {
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    // good time : O(NlogN + MlogM)
    public void solve2(int a[], int b[]) {
        int n = a.length, m = b.length;
        for (int i = 0; i < Math.min(n, m); i++) {
            if (a[n - i - 1] > b[i]) {
                int temp = a[n - i - 1];
                a[n - i - 1] = b[i];
                b[i] = temp;
            }
        }
        for (int gap = nextgap(n); gap > 0; gap = nextgap(gap)) {
            for (int i = 0; i + gap < n; i++) {
                if (a[i] > a[i + gap]) {
                    int temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                }
            }
        }

        for (int gap = nextgap(m); gap > 0; gap = nextgap(gap)) {
            for (int i = 0; i + gap < m; i++) {
                if (b[i] > b[i + gap]) {
                    int temp = b[i];
                    b[i] = b[i + gap];
                    b[i + gap] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }


    public int nextgap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

}