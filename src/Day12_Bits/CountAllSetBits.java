package Day12_Bits;

public class CountAllSetBits {
    public void solve(int n) {
        int cnt = 0;
        while (n > 0) {
            n &= (n - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
