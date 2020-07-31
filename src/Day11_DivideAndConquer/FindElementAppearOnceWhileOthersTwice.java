package Day11_DivideAndConquer;

public class FindElementAppearOnceWhileOthersTwice {
    public void solve(int a[]) {
        System.out.println(go(a));
    }

    private int go(int a[]) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid + 1 < a.length && a[mid] == a[mid + 1]) mid++;
            int cnt = mid + 1;
            if (cnt % 2 == 0) low = mid + 1;
            else high = mid - 1;
        }
        return low >= a.length ? -1 : a[low];
    }
}
