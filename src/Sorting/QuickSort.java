package Sorting;

public class QuickSort {

    public void sort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    private void sort(int a[], int low, int high) {
        if (low < high) {
            int pos = partition(a, low, high);
            sort(a, low, pos - 1);
            sort(a, pos + 1, high);
        }
    }

    private int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, high);
        return i;
    }

    private void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
