package Extras;

public class CompareTwoStringWithRollingHash {
    //https://leetcode.com/problems/longest-chunked-palindrome-decomposition/

    public int longestDecomposition(String s) {
        char a[] = s.toCharArray();
        int n = a.length, ans = 0;
        int l = 0, r = n - 1;
        long base1 = 26, base2 = 1, hash1 = 0, hash2 = 0;
        final long mod = (long) (1e9) + 9L;

        while (l <= r) {
            char c1 = a[l], c2 = a[r];
            hash1 = (hash1 * base1 + (c1 - 'a' + 1)) % mod;
            hash2 = (hash2 + (c2 - 'a' + 1) * base2) % mod;
            base2 *= base1;
            base2 %= mod;

            if (hash1 == hash2) {
                if (l == r) ans++;
                else ans += 2;
                hash1 = hash2 = 0;
                base2 = 1;
            }
            l++;
            r--;

        }

        if (hash1 != 0) ans++;

        return ans;
    }


}
