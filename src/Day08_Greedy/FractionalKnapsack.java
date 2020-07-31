package Day08_Greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public void solve(int wt[], int val[], int cap) {
        int n = wt.length;
        double pair[][] = new double[n][4];
        for (int i = 0; i < n; i++) {
            pair[i][0] = wt[i];
            pair[i][1] = val[i];
            pair[i][2] = (val[i] * 1.0d) / wt[i];
            pair[i][3] = i;
        }
        Arrays.sort(pair, (o1, o2) -> Double.compare(o2[2], o1[2]));
//        System.out.println(Arrays.deepToString(pair));
        double totalval = 0.0d;
        for (int i = 0; i < n; i++) {
            if (cap >= pair[i][0]) {
                totalval += pair[i][1];
                cap -= pair[i][0];
            } else {
                double pval = cap / pair[i][0];
                totalval += pval * pair[i][1];
                cap -= pair[i][0] * pval;
                break;
            }
        }
        System.out.println(totalval);
    }
}
