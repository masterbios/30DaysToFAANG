package Day11_DivideAndConquer;

public class FindElementSortedRotatedArray {

    // include low, exclude mid
    // exclude mid, include high
    public void solve(int a[], int find) {
        System.out.println(go(a, find));
    }

    public int go(int a[], int find) {
        int n = a.length, low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == find) {
                return mid;
            } else if (a[low] <= a[mid]) {
                if (a[low] <= find && find < a[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (a[mid] < find && find <= a[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    // find pivot and then apply BS
    public int go2(int a[], int find) {
        int pivot = findPivot(a);
        if (pivot == -1) return binarySearch(a, 0, a.length - 1, find);
        if (find == a[pivot]) return pivot;
        if (a[0] <= find && find < a[pivot]) return binarySearch(a, 0, pivot, find);
        return binarySearch(a, pivot + 1, a.length - 1, find);
    }

    public int binarySearch(int a[], int low, int high, int find) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < find) low = mid + 1;
            else if (a[mid] == find) return mid;
            else high = mid - 1;
        }
        return -1;
    }

    public int findPivot(int a[]) {
        return findPivot(a, 0, a.length - 1);
    }

    public int findPivot(int a[], int low, int high) {
        if (low > high) return -1;
        if (low == high) return low;
        int mid = low + (high - low) / 2;
        if (mid < high && a[mid] > a[mid + 1]) return mid;
        if (low < mid && a[mid - 1] > a[mid]) return (mid - 1);
        if (a[low] >= a[mid]) return findPivot(a, low, mid - 1);
        return findPivot(a, mid + 1, high);
    }
}
