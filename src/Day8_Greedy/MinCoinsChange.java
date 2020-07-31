package Day8_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCoinsChange {
    public void solve(int vals[], int amount) {
        int n = vals.length;
        Arrays.sort(vals);
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= vals[i]) {
                ans.add(vals[i]);
                amount -= vals[i];
            }
        }
        System.out.println(ans);
    }
}
