package Day03_Maths;

public class TrailingZeros {
    public void solve(int n) {
        int res = 0;
        for (int i = 5; n / i >= 1; i *= 5) res += n / i;
        System.out.println(res);
    }
}
