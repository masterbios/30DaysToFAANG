package Day04_Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithGivenXor {
    public int solve(int a[], int m) {
        int count = 0, xorsum = 0;
        Map<Integer, Integer> map= new HashMap<>();
        for (int x : a) {
            xorsum ^= x;
            int need = xorsum ^ m;
            count += map.getOrDefault(need, 0);
            map.put(xorsum, map.getOrDefault(xorsum, 0) + 1);
        }
        count += map.getOrDefault(m, 0);
        return count;
    }
}
