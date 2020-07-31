package Day10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KthPermutationSequence {
    int k;

    public void solve(int n, int k) {
        this.k = k;
        String ans = findValue(n);
        System.out.println(ans);
    }

    private String findValue(int n) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) list.add(i);
        k--;
        for (int i = 0; i < n; i++) {
            int ans = getValue(n - i);
            sb.append("" + list.get(ans));
            list.remove(ans);
        }
        return sb.toString();
    }

    private int getValue(int n) {
        if (n == 1) return 0;
        n--;
        int ans = 0, fact = n;
        while (this.k >= fact && n > 1) {
            fact *= (n - 1);
            n--;
        }
        ans = this.k / fact;
        this.k %= fact;
        return ans;
    }
}
