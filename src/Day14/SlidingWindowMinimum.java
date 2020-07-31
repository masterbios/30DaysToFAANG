package Day14;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMinimum {

    public void solve(int a[], int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = a.length, itr = 0;
        int ans[] = new int[n - k + 1];

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && a[q.peekLast()] >= a[i]) q.pollLast();
            q.offerLast(i);
        }
        for (int i = k; i < n; i++) {
            ans[itr++] = a[q.peekFirst()];
            while (!q.isEmpty() && q.peekFirst() <= i - k) q.pollFirst();
            while (!q.isEmpty() && a[q.peekLast()] >= a[i]) q.pollLast();
            q.offerLast(i);
        }
        ans[itr++] = a[q.peekFirst()];
        System.out.println(Arrays.toString(ans));
    }
}
