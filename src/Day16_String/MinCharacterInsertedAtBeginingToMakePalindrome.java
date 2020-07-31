package Day16_String;

import java.util.Arrays;

public class MinCharacterInsertedAtBeginingToMakePalindrome {

    public void solve(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        sb.reverse().append('$').append(rev);
        char a[] = sb.toString().toCharArray();
        int ans = s.length() - prefixFunction(a);
        System.out.println(ans);
    }

    public int prefixFunction(char a[]) {
        int n = a.length;
        int lps[] = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && a[i] != a[j]) j = lps[j - 1];
            if (a[i] == a[j]) j++;
            lps[i] = j;
        }
        System.out.println(Arrays.toString(lps));
        return lps[n - 1];
    }
}
