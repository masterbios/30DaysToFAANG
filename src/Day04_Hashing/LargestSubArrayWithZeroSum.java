package Day04_Hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {
    public int solve(int a[]) {
        int max = 0, n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
