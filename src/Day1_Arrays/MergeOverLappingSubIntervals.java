package Day1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverLappingSubIntervals {
    // good
    public void solve2(int a[][]) {
        int n = a.length;
        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (a[index][1] >= a[i][0]) {
                a[index][0] = Math.min(a[index][0], a[i][0]);
                a[index][1] = Math.max(a[index][1], a[i][1]);
            } else {
                a[++index] = a[i];
            }
        }
        for (int i = 0; i <= index; i++) {
            System.out.print("["+a[i][0]+","+a[i][1]+"] ");
        }
        System.out.println();
    }

    // bad
    public void solve1(int a[][]) {
        int n = a.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            else return o2[1] - o1[1];
        });
        list.add(a[0]);
        for (int i = 1; i < n; i++) {
            int size = list.size() - 1;
            int prev[] = list.get(size);
            int cur[] = a[i];
            if (overlap(prev, cur)) {
                int start = Math.min(prev[0], cur[0]);
                int end = Math.max(prev[1], cur[1]);
                list.get(size)[0] = start;
                list.get(size)[1] = end;
            } else {
                list.add(cur);
            }
        }
        int ans[][] = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        System.out.println(Arrays.deepToString(ans));
    }

    public boolean overlap(int x[], int y[]) {
        if (x[0] <= y[0] && y[0] <= x[1]) return true;
        return false;
    }
}
