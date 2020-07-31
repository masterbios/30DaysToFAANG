package Day22_MixedQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberInAWindow {

    public void solve(int a[], int k) {
        int ans[] = go(a, k);
        System.out.println(Arrays.toString(ans));
    }

    private int[] go(int a[], int k) {
        int n = a.length;
        int ans[] = new int[n - k + 1];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for (int i = k; i < n; i++) {

            ans[i - k] = map.size();
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);

            int val = a[i - k];
            if (map.get(val) == 1) map.remove(val);
            else map.put(val, map.get(val) - 1);

        }

        ans[n - k] = map.size();

        return ans;
    }
}
