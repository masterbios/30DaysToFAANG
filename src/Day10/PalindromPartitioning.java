package Day10;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {
    List<List<String>> list;
    int n;
    String s;
    boolean isPal[][];

    public void partition(String s) {
        list = new ArrayList<>();
        this.n = s.length();
        this.s = s;
        this.isPal = new boolean[n][n];
        init();
        go(0, new ArrayList<>());
        for (List<String> x : list) System.out.println(x);
    }

    public void go(int idx, List<String> cur) {
        if (idx >= n) {
            list.add(new ArrayList<>(cur));
        }
        for (int i = idx; i < n; i++) {
            if (isPal[idx][i]) {
                cur.add(s.substring(idx, i + 1));
                go(i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public void init() {
        char a[] = s.toCharArray();
        for (int i = 0; i < n; i++) isPal[i][i] = true;
        for (int i = 0; i + 1 < n; i++) if (a[i] == a[i + 1]) {
            isPal[i][i + 1] = true;
        }
        for (int size = 2; size < n; size++) {
            for (int l = 0; l + size < n; l++) {
                int r = l + size;
                if (a[l] == a[r] && isPal[l + 1][r - 1]) {
                    isPal[l][r] = true;
                }
            }
        }
    }
}
