package Day03_Maths;

public class xPowY {

    public double solve(int x, int y) {
        double res = 1;
        while (y > 0) {
            if (y % 2 == 1) res = res * x;
            x = x * x;
            y >>= 1;
        }
        return res;
    }

    // for negative
    public double solve1(int x, int y) {
        boolean isNegative = false;
        if (y < 0) {
            isNegative = true;
            y = -y;
        }
        double ans = solve(x, y);
        if (isNegative) ans = 1.0d / ans;
        return ans;
    }
}
