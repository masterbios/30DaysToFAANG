package Day15_String;

public class LongestPalindromeInAString {

    public void solve(String s) {
        System.out.println(go(s));
    }

    private String go(String s) {
        char a[] = s.toCharArray();
        int n = a.length, max = 0, start = 0, end = 0;
        for (int center = 0; center < n; center++) {
            int even[] = isPalindrome(a, center, center + 1);
            int odd[] = isPalindrome(a, center, center);
            int evenlen = even[1] - even[0] + 1;
            int oddlen = odd[1] - odd[0] + 1;
            if (evenlen > max) {
                max = evenlen;
                start = even[0];
                end = even[1];
            } else if (oddlen > max) {
                max = oddlen;
                start = odd[0];
                end = odd[1];
            }
        }
        return s.substring(start, end + 1);
    }

    private int[] isPalindrome(char a[], int l, int r) {
        while (l >= 0 && r < a.length && a[l] == a[r]) {
            l--;
            r++;
        }
        return new int[] {l + 1, r - 1};
    }
}
