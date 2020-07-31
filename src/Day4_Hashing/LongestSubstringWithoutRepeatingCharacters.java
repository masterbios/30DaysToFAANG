package Day4_Hashing;

public class LongestSubstringWithoutRepeatingCharacters {
    // geeksforgeeks
    public void solve(String s) {
        char a[] = s.toCharArray();
        int n = a.length, ans = 0;
        int index[] = new int[128];
        for (int i = 0, j = 0; j < n; j++) {
            i = Math.max(i, index[a[j]]);
            ans = Math.max(ans, j - i + 1);
            index[a[j]] = j + 1;
        }
        System.out.println(ans);
    }
}
