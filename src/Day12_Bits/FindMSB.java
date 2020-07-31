package Day12_Bits;

public class FindMSB {
    public void solve(int n) {
        int bit = (int) (Math.log(n) / Math.log(2));
        System.out.println(bit);
    }
}
