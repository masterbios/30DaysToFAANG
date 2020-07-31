package Day8_Greedy;

import java.util.Arrays;

public class JobSchedulingProblem {
    // worst
    // 0->id, 1->deadline, 2->profit
    public void solve1(int a[][]) {
        int n = a.length;
        Arrays.sort(a, (o1, o2) -> o2[2] - o1[2]);
        int result[] = new int[n];
        boolean slot[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, a[i][1]) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = i;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                char val = (char) ('a' + (a[result[i]][0] - 'a'));
                System.out.print(val + " ");
            }
        }
        System.out.println();
    }

    // good
    // 0->id, 1->deadline, 2->profit
    // time complexity : O(n * log(n))

    int par[];
    public void solve2(int a[][]) {
        int n = a.length, max = 0;
        for (int cur[] : a) max = Math.max(max, cur[1]);
        par = new int[max + 1];
        for (int i = 0; i <= max; i++) par[i] = i;
        Arrays.sort(a, (o1, o2) -> o2[2] - o1[2]);
        for (int i = 0; i < n; i++) {
            int end = find(a[i][1]);
            if (end > 0) {
                char val = (char) ('a' + (a[i][0] - 'a'));
                merge(end - 1, end);
                System.out.print(val + " ");
            }
        }
        System.out.println();
    }

    public int find(int node) {
        if (par[node] == node) return node;
        else return par[node] = find(par[node]);
    }

    public void merge(int start, int end) {
        par[end] = start;
    }
}
