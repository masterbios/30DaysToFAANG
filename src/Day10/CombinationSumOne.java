package Day10;

/*
Input: candidates = [2,3,6,7], target = 7,
A solution set is: [[7],[2,2,3]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumOne {
    List<List<Integer>> list;

    public void solve(int a[], int target) {
        list = new ArrayList<>();
        go(a, target);
        for (List<Integer> x : list) System.out.println(x);
    }

    public void go(int a[], int target) {
        Arrays.sort(a);
        go(a, 0, a.length, target, new ArrayList<>());
    }

    public void go(int a[], int idx, int n, int target, List<Integer> cur) {
        if (target == 0) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < n && target >= a[i]; i++) {
            cur.add(a[i]);
            go(a, i, n, target - a[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}
