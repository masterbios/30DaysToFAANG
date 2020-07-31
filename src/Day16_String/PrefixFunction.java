package Day16_String;

import java.util.Arrays;

public class PrefixFunction {
    public void solve(String s) {
        int n = s.length();
        int lps[] = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = lps[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            lps[i] = j;
        }
        System.out.println(Arrays.toString(lps));
    }
}
