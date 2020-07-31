package Day10;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumTwo {
    List<List<Integer>> list;

    public void solve(int a[], int target) {
        list = new ArrayList<>();
        solve(a, 0, target, new ArrayList<>());
        for (List<Integer> x : list) System.out.println(x);
    }

    public void solve(int a[], int idx, int target, List<Integer> cur) {
        if (target == 0) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < a.length && target >= a[i]; i++) {
            if (i > idx && a[i - 1] == a[i]) continue;
            cur.add(a[i]);
            solve(a, i + 1, target - a[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
