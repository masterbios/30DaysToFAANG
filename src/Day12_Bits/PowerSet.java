package Day12_Bits;

public class PowerSet {
    public void solve(int a[]) {
        int n = a.length;
        for (int val = 0; val < (1 << n); val++) {
            System.out.print("[");
            for (int mask = 0; mask < n; mask++) {
                if ((val & (1 << mask)) != 0) {
                    System.out.print(a[mask] + " ");
                }
            }
            System.out.println("]");
        }
    }
}
