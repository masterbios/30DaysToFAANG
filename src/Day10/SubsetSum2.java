package Day10;

public class SubsetSum2 {

    public void solve(int a[], int k) {
        System.out.println(partitionSubsetK(a, k));
    }

    private boolean partitionSubsetK(int a[], int k) {
        int sum = 0, n = a.length;
        for (int val : a) sum += val;
        if (k <= 0 || sum % k != 0) return false;
        boolean vis[] = new boolean[n];
        return partitionK(a, 0, vis, k, 0, sum / k);
    }

    private boolean partitionK(int a[], int idx, boolean vis[], int k, int cursum, int target) {
        if (k == 1) return true;
        if (cursum == target) return partitionK(a, 0, vis, k - 1, 0, target);
        for (int i = idx; i < a.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                if (partitionK(a, i + 1, vis, k, cursum + a[i], target)) return true;
                vis[i] = false;
            }
        }
        return false;
    }

}
