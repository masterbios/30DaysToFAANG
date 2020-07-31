package Day1_Arrays;

public class FindMissingAndRepeatNumber {
    public void solve(int a[]) {
        int n = a.length, missing = -1, repeat = -1;
        for (int i = 0; i < n; i++) {
            int pos = Math.abs(a[i]) - 1;
            if (a[pos] > 0) a[pos] = -a[pos];
            else repeat = pos + 1;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) missing = i + 1;
        }
        System.out.println("missing=" + missing + " repeat=" + repeat);
    }
}
