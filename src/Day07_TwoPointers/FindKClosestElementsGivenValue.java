package Day07_TwoPointers;


public class FindKClosestElementsGivenValue {

    //https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
    // time complexity : O(logN + K)
    // time complexity : O(1)

    public void solve(int a[], int x, int k) {
        int n = a.length;
        int r = findCrossOver(a, 0, n - 1, x), l = r - 1;
        while (l >= 0 && a[l] == x) l--;
        System.out.println(l + " " + r);
        while (l >= 0 && r < n && k--> 0) {
            if (x - a[l] < a[r] - x) {
                System.out.print(a[l] + " ");
                l--;
            } else {
                System.out.print(a[r] + " ");
                r++;
            }
        }
        while (l >= 0 && k--> 0) {
            System.out.print(a[l] + " ");
            l--;
        }
        while (r < n && k--> 0) {
            System.out.print(a[r] + " ");
            r++;
        }
    }

    private int findCrossOver(int a[], int low, int high, int find) {
        if (a[high] <= find) return high;
        if (a[low] > find) return low;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= find) low = mid + 1;
            else high = mid - 1;
        }
        // low points to element greater than find so it should be right pointer
        return low;
    }
}
