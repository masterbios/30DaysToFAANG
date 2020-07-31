package Day12_Bits;

public class FindSquareWithoutUsingMultiplyDivide {
    public void solve(int n) {
        int sq = square(n);
        System.out.println(sq);
    }

    /*
    If n is even, it can be written as
        n = 2*x
        n^2 = (2*x)^2 = 4*x^2

    If n is odd, it can be written as
        n = 2*x + 1
        n^2 = (2*x + 1)^2 = 4*x^2 + 4*x + 1
     */

    private int square(int n) {
        if (n == 0) return 0;
        if (n < 0) n = -n;
        int floor = n >> 1;
        if ((n & 1) == 0) { // even
            return (square(floor) << 2);
        } else {
            return (square(floor) << 2) + (floor << 2) + 1;
        }
    }
}
