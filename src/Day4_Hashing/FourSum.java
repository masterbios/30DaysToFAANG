package Day4_Hashing;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
    public void solve(int a[]) {
        int n = a.length;
    }

    public void solve(int a[], int sum) {
        Map<Integer, Pair> map = new HashMap<>();
        int n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(a[i] + a[j], new Pair(a[i] + a[j], i, j));
            }
        }
        for (int i = 0; i + 1 < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cursum = a[i] + a[j];
                int need = sum - cursum;
                if (map.containsKey(need)) {
                    Pair idx = map.get(need);
                    if (idx.i != i && idx.j != i && idx.j != j && idx.i != j) {
                        System.out.println(a[idx.i] + " " + a[idx.j] + " " + a[i] + " " + a[j]);
                        return;
                    }
                }
            }
        }
    }

    class Pair {
        int sum, i, j;
        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
}
