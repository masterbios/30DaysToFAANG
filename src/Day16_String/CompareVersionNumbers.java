package Day16_String;

import java.util.Arrays;

public class CompareVersionNumbers {

    public void solve(String s1, String s2) {
        System.out.println(hardWay(s1, s2));
        System.out.println(javaWay(s1, s2));
    }

    private String hardWay(String s1, String s2) {
        char a[] = s1.toCharArray();
        char b[] = s2.toCharArray();
        int n = a.length, m = b.length, i = 0, j = 0;

        while (i < n || j < m) {
            int num1 = 0, num2 = 0;
            while (i < n && a[i] != '.') {
                num1 = num1 * 10 + (a[i] - '0');
                i++;
            }
            while (j < m && b[j] != '.') {
                num2 = num2 * 10 + (b[j] - '0');
                j++;
            }
            if (num1 > num2) return "second is smallest";
            else if (num1 < num2) return "first is smallest";
            num1 = num2 = 0;
            i++;
            j++;
        }
        return "both are same";
    }

    private String javaWay(String s1, String s2) {
        String a[] = s1.split("\\.");
        String b[] = s2.split("\\.");
        int i, n = a.length, m = b.length;

        for (i = 0; i < Math.min(n, m); i++) {
            int num1 = Integer.parseInt(a[i]);
            int num2 = Integer.parseInt(b[i]);
            if (num1 < num2) return "first is smallest";
            else if (num1 > num2) return "second is smallest";
        }
        if (i < n) return "second is smallest";
        if (i < m) return "first is smallest";
        return "both are same";
    }
}
