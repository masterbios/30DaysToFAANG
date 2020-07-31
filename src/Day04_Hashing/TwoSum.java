package Day04_Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public void solve(int[] a, int target) {
        int ans[] = new int[2], n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int need = target - a[i];
            if (map.containsKey(need)) {
                ans[0] = map.get(need);
                ans[1] = i;
                break;
            }
            map.put(a[i], i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
