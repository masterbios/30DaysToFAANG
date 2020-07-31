package Day12_Bits;

public class CheckPowOfTwo {

    public void solve(int n) {
        boolean ans = (n & (n - 1)) == 0;
        System.out.println(ans);
    }
}
