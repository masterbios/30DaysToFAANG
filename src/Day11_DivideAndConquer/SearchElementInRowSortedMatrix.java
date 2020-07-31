package Day11_DivideAndConquer;

public class SearchElementInRowSortedMatrix {

    public void solve(int a[][], int target) {
        System.out.println(searchMatrix(a, target));
    }

    public boolean searchMatrix(int[][] a, int target) {
        if (a == null || a.length == 0 || a[0].length == 0) return false;
        int r = a.length, c = a[0].length;
        int low = 0, high = c - 1, row = -1;
        for (int i = 0; i < r; i++) {
            if (a[i][0] <= target && a[i][c - 1] >= target) {
                row = i;
            }
        }
        if (row == -1) return false;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[row][mid] < target) low = mid + 1;
            else if (a[row][mid] == target) return true;
            else high = mid - 1;
        }
        return false;
    }

}
