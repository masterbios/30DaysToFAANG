package Sorting;

import java.util.Arrays;

public class MergeSort {
    public void sort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int a[], int l, int r) {
        if (l >= r) return;
        int mid = (l + r) >> 1;
        sort(a, l, mid);
        sort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private void merge(int a[], int l, int mid, int r) {
        int left[] = Arrays.copyOfRange(a, l, mid + 1);
        int right[] = Arrays.copyOfRange(a, mid + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }
        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}
