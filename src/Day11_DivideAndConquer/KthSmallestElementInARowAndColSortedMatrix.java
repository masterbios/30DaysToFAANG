package Day11_DivideAndConquer;

import java.util.PriorityQueue;

public class KthSmallestElementInARowAndColSortedMatrix {

    public void solve(int a[][], int k) {
        System.out.println(go(a, k));
    }

    public int go(int a[][], int k) {
        int r = a.length, c = a[0].length;
        if (r * c < k) return -1;
        PriorityQueue<Tuple> q = new PriorityQueue<>();
        for (int i = 0; i < r; i++) {
            q.offer(new Tuple(a[i][0], i, 0));
        }
        int cnt = 1;
        while (cnt < k) {
            cnt++;
            Tuple cur = q.poll();
            if (cur.y + 1 >= c) continue;
            q.offer(new Tuple(a[cur.x][cur.y + 1], cur.x, cur.y + 1));
        }
        return q.peek().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x, y, val;

        public Tuple(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Tuple that) {
            return this.val - that.val;
        }
        public void print(int cnt) {
            System.out.println("val=" + val + " x=" + x + " y=" + y + " cnt=" + cnt);
        }
    }
}

