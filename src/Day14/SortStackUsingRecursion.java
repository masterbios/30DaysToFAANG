package Day14;

import java.util.Stack;

public class SortStackUsingRecursion {

    public void solve(int a[]) {
        Stack<Integer> st = new Stack<>();
        for (int x : a) st.push(x);
        System.out.println("Before: " + st);
        sort(st);
        System.out.println("After: " + st);
    }

    public void sort(Stack<Integer> st) {
        if (st.isEmpty()) return;
        int cur = st.pop();
        sort(st);
        insertSorted(st, cur);
    }

    public void insertSorted(Stack<Integer> st, int val) {
        if (st.isEmpty() || st.peek() <= val) {
            st.push(val);
            return;
        }
        int cur = st.pop();
        insertSorted(st, val);
        st.push(cur);
    }
}
