package Day12_Bits;

public class DivideWithoutDivideOperator {

    public void solve(int dividend, int divisor) {
        int ans = divide(dividend, divisor);
        System.out.println(ans);
    }


    private int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int ans = 0;
        while (a - b >= 0) {
            int mask;
            for (mask = 0; (a - (b << 1 << mask)) >= 0; mask++);
                ans += (1 << mask);
                a -= (b << mask);
        }
        return (dividend > 0 == divisor > 0) ? ans : -ans;
    }
}
