package Day26_DP;

import java.util.Arrays;

public class LongestPalindromicSubstringUsingManachers {

    public void solve(String s) {
        char a[] = s.toCharArray();
        int ans[] = go(a);
        System.out.println(ans[1] - ans[0] + 1);
    }

    private int[] go(char a[]) {
        int n = a.length;
        int odd[] = new int[n];
        int even[] = new int[n];
        int ans[] = new int[2];
        int max = 0;

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(odd[l + r - i], r - i + 1);
            while (i - k >= 0 && i + k < n && a[i - k] == a[i + k]) k++;
            odd[i] = k--;
            if (max < odd[i]) {
                max = odd[i];
                ans[0] = i - odd[i] + 1;
                ans[1] = i + odd[i] - 1;
            }
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }

        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(even[l + r - i + 1], r - i + 1);
            while (i - k - 1 >= 0 && i + k < n && a[i - k - 1] == a[i + k]) k++;
            even[i] = k--;
            if (max <= even[i]) {
                max = even[i];
                ans[0] = i - even[i];
                ans[1] = i + even[i] - 1;
            }
            if (i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }

        return ans;
    }
}
