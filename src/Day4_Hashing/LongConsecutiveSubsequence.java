package Day4_Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongConsecutiveSubsequence {
    public int solve(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        int max = 0;
        for (int x : a) {
            int cnt = 0, y = x;
            if (!set.contains(y - 1)) {
                while (set.contains(y)) {
                    y++;
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
