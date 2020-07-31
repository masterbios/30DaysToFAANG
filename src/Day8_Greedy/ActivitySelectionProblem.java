package Day8_Greedy;

import java.util.Arrays;

public class ActivitySelectionProblem {
    public void solve(int a[][]) {
        int n = a.length;
        Arrays.sort(a, (o1, o2) -> o1[1] - o2[1]);
        System.out.println(Arrays.toString(a[0]));
        int prev = a[0][1];
        for (int i = 1; i < n; i++) {
            if (prev <= a[i][0]) {
                System.out.println(Arrays.toString(a[i]));
                prev = a[i][1];
            }
        }
    }
}
