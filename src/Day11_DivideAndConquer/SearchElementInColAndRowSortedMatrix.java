package Day11_DivideAndConquer;

public class SearchElementInColAndRowSortedMatrix {

    public void solve(int a[][], int find) {
        System.out.println(searchMatrix(a, find));
    }

    public boolean searchMatrix(int[][] a, int find) {
        if (a == null || a.length == 0 || a[0].length == 0) return false;
        int r = a.length, c = a[0].length;
        int min = a[0][0], max = a[r - 1][c - 1];
        if (find < min || find > max) return false;
        int i = 0, j = c - 1;
        while (i < r && j >= 0) {
            if (a[i][j] < find) i++;
            else if (a[i][j] == find) return true;
            else j--;
        }
        return false;
    }
}
