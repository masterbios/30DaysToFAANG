package Day8_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NmeetingInOneRoom {
    public void solve(int a[][]) {
        int n = a.length;
        int v[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            v[i][0] = a[i][0];
            v[i][1] = a[i][1];
            v[i][2] = i + 1;
        }
        Arrays.sort(v, (o1, o2) -> o1[1] - o2[1]);
//        System.out.println(Arrays.deepToString(v));
        List<Integer> list = new ArrayList<>();
        list.add(v[0][2]);
        int prev = v[0][1];
        for (int i = 1; i < n; i++) {
            if (v[i][0] >= prev) {
                list.add(v[i][2]);
                prev = v[i][1];
            }
        }
        System.out.println(list);
    }
}
