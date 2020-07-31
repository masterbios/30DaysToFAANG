package Day15_String;

public class StringToAtoi {

    /*
        Corner cases
        "42"
        "   -42"
        "4193 with words"
        "-91283472332"
        "91283472332"
        ""
        "+"
        " "
     */

    public void solve(String num) {
        System.out.println(atoi(num));
    }

    private int atoi(String s) {
        if (s == null || s.length() == 0) return 0;
        char a[] = s.toCharArray();
        int i = 0, num = 0, sign = 1, n = a.length;

        while (i < n && a[i] == ' ') i++;

        if (i < n && (a[i] == '+' || a[i] == '-')) {
            sign = sign - 2 * (a[i] == '-' ? 1 : 0);
            i++;
        }

        if (i < n && !(a[i] >= '0' && a[i] <= '9')) return 0;

        while (i < n && a[i] >= '0' && a[i] <= '9') {
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && (a[i] - '0') > 7)) {
                if (sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            num = (num * 10) + (a[i] - '0');
            i++;
        }

        return (num * sign);
    }
}
