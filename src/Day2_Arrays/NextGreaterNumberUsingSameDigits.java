package Day2_Arrays;

import java.util.Arrays;

public class NextGreaterNumberUsingSameDigits {
    public void solve(int a[]) {
        boolean flag = true;
        int n = a.length, i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i == 0) {
            flag = false;
        } else {
            int x = a[i - 1], min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] > x && a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i - 1, min);
            Arrays.sort(a, i, n);
        }
        if (!flag) System.out.println("Not possible");
        else System.out.println(Arrays.toString(a));
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
