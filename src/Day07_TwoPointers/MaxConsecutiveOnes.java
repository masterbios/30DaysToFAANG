package Day07_TwoPointers;

public class MaxConsecutiveOnes {
    public void solve(int a[]) {
        int n = a.length, max = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) cnt = 0;
            else cnt++;
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }
}
