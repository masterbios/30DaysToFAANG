package Day07_TwoPointers;

import java.util.Arrays;

public class ThreeSum {
    public void solve(int a[]) {
        int n = a.length;
        Arrays.sort(a);
        for (int i = 0; i + 2 < n; i++) {
            int l = i + 1, r = n - 1;
            int prev = a[i];
            while (l < r) {
                if (-a[i] < a[l] + a[r]) {
                    r--;
                } else if (-a[i] == a[l] + a[r]){
                    System.out.println(a[i] + " " + a[l] + " " + a[r]);
                    int left = a[l], right = a[r];
                    while (l < r && a[l] == left) l++;
                    while (l < r && a[r] == right) r--;
                } else {
                    l++;
                }
            }
            while (i + 1 < n && a[i + 1] == prev) {
                i++;
            }
        }
    }
}
