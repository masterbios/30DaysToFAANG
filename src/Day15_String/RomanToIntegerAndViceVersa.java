package Day15_String;

public class RomanToIntegerAndViceVersa {

    public void solve(String s) {
        char a[] = s.toCharArray();
        int numeral = romanToInteger(a);
        String roman = integerToRoman(numeral);
        System.out.println(numeral + " " + roman);
    }


    private String integerToRoman(int num) {
        // 0, 1000, 2000, 3000
        String m[] = {
          "", "M", "MM", "MMM"
        };

        // 0, 100, 200, 300, 400, 500, 600, 700, 800, 900
        String c[] = {
          "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
        };

        // 0, 10, 20, 30, 40, 50, 60, 70, 80, 90
        String x[] = {
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
        };

        // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        String single[] = {
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
        };
        String ans = m[num / 1000];
        ans += c[(num % 1000) / 100];
        ans += x[(num % 100) / 10];
        ans += single[num % 10];
        return ans;
    }

    private int romanToInteger(char a[]) {
        int num = 0, n = a.length;
        for (int i = 0; i < n; i++) {
            int v1 = value(a[i]);
            if (i + 1 < n) {
                int v2 = value(a[i + 1]);
                if (v1 >= v2) {
                    num += v1;
                } else {
                    num += v2 - v1;
                    i++;
                }
            } else {
                num += v1;
            }
        }
        return num;
    }

    private int value(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return -1;
    }
}
