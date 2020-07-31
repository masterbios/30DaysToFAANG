package Day26_DP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public void solve(String dict[], String word) {
        int n = word.length();
        Set<String> set = new HashSet<>(Arrays.asList(dict));
        boolean dp[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String cur = word.substring(j, i + 1);
                if ((j == 0 || dp[j - 1]) && set.contains(cur)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(dp[n - 1]);
    }

}
