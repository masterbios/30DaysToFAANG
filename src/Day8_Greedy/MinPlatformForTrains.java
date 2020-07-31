package Day8_Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinPlatformForTrains {
    public void solve(int arr[], int dep[]) {
        int n = arr.length;
        int a[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = arr[i];
            a[i][1] = dep[i];
        }
        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.offer(a[0]);
        for (int i = 1; i < n; i++) {
            int cur[] = a[i];
            int earlyend[] = q.poll();
            if (earlyend[1] <= cur[0]) {
                earlyend[1] = cur[1];
                q.offer(earlyend);
            } else {
                q.offer(cur);
                q.offer(earlyend);
            }
        }
        System.out.println(q.size());
    }

    // best
    // Merge sort merge process
    public void solve1(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int req = 1, ans = 1, i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                req++;
                i++;
            } else {
                req--;
                j++;
            }
            ans = Math.max(ans, req);
        }
        System.out.println(ans);
    }
}
