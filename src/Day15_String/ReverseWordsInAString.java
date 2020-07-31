package Day15_String;

public class ReverseWordsInAString {
    public void solve(String s) {
        System.out.println(java(s));
        System.out.println(theHardWay(s));
    }

    private String java(String s) {
        String a[] = s.split(" ");
        int n = a.length;
        String ans = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans += " " + a[i];
        }
        return ans;
    }

    private String theHardWay(String s) {
        s += " ";
        String ans = "", cur = "";
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (ans.length() == 0) {
                    ans = reverse(cur);
                } else {
                    ans += " " + reverse(cur);
                }
                cur = "";
            } else {
                cur += c;
            }
        }
        ans = reverse(ans);
        return ans;
    }

    private String reverse(String s) {
        int l = 0, r = s.length() - 1;
        char a[] = s.toCharArray();
        while (l < r) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
        return new String(a);
    }
}
