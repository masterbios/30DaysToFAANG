package Day11_DivideAndConquer;

public class NthRoot {
    // a ^ n = x so, find a
    public void solve(double x, int n) {
        double low = 0, high = 0;
        if (x >= 0 && x <= 1) {
            low = x;
            high = 1;
        } else {
            low = 1;
            high = x;
        }
        double epsilon = 0.000000001;
        double guess = (low + high) / 2;
        while (Math.abs(Math.pow(guess, n) - x) >= epsilon) {
            if (Math.pow(guess, n) > x) high = guess;
            else low = guess;
            guess = (low + high) / 2;
        }
        System.out.println(guess);
    }
}
