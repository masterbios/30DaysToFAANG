package Day22_MixedQuestions;

import java.util.Arrays;
import java.util.Random;

public class KthSmallestElementUnsortedArray {

    Random rand;

    public void solve(int a[], int k) {
        rand = new Random();
        int ans = kthSmallest(a, 0, a.length - 1, k);
        System.out.println(ans);
    }

    private int kthSmallest(int a[], int l, int r, int k) {
        if (k > 0 && r - l + 1 >= k) {
            int pos = partition(a, l, r);
            if (pos - l == k - 1) return a[pos];
            if (pos - l > k - 1) return kthSmallest(a, l, pos - 1, k);
            return kthSmallest(a, pos + 1, r, k - pos + l - 1);
        }
        return Integer.MAX_VALUE;
    }

    private int random(int min, int max) {
        if (min == max) return min;
        return rand.nextInt(max - min) + min;
    }

    private int partition(int a[], int l, int r) {
        int pos = random(l, r);
        swap(a, pos, r);
        int i = l, pivot = a[r];
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    private void swap(int a[],int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
