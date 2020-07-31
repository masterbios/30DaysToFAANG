package Day1_Arrays;

public class FindDuplicates {

    // tortoise and hare method

    public int solve(int a[]) {
        if (a == null) return -1;
        int tor = a[0], hare = a[0];
        do {
            tor = a[tor];
            hare = a[a[hare]];
        } while (tor != hare);
        int ptr1 = a[0], ptr2 = hare;
        while (ptr1 != ptr2) {
            ptr1 = a[ptr1];
            ptr2 = a[ptr2];
        }
        return ptr1;
    }

    // find all elements repeating multiples time
    // 0 <= a[i] <= n - 1
    // [1,1,1,1,2,2,2,3,3,3,4] => [1,2,3,4]

    public void solve1(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int idx = a[i] % n;
            a[idx] += n;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] >= 2 * n) System.out.print(i);
        }
    }
}
