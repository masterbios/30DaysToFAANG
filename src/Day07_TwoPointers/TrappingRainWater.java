package Day07_TwoPointers;

public class TrappingRainWater {
    public void solve(int a[]) {
        int n = a.length, l = 0, r = n - 1;
        int maxleft = 0, maxright = 0;
        int ans = 0;
        while (l <= r) {
            if (a[l] < a[r]) {
                if (a[l] < maxleft) ans += maxleft - a[l];
                else maxleft = a[l];
                l++;
            } else {
                if (a[r] < maxright) ans += maxright - a[r];
                else maxright = a[r];
                r--;
            }
        }
        print(ans);
    }

    public void solve2(int a[]) {
        int n = a.length, ans = 0;
        int maxleft[] = new int[n];
        int maxright[] = new int[n];
        maxleft[0] = a[0];
        maxright[n - 1] = a[n - 1];
        for (int i = 1; i < n; i++) {
            maxleft[i] = Math.max(maxleft[i - 1], a[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxright[i] = Math.max(maxright[i + 1], a[i]);
        }
        for (int i = 0; i < n; i++) {
            ans += Math.min(maxleft[i], maxright[i]) - a[i];
        }
        print(ans);
    }

    private void print(int ans) {
        System.out.println(ans);
    }
}
