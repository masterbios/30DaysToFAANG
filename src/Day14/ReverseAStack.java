package Day14;

import java.util.Arrays;
import java.util.Stack;

public class ReverseAStack {
    public void solve(int a[]) {
        Stack<Integer> st = new Stack<>();
        for (int x : a) st.push(x);
        System.out.println("Before : " + st);
        reverse(st);
        System.out.println("After : " + st);
    }

    public void reverse(Stack<Integer> st) {
        if (st.size() == 0) return;
        int val = st.pop();
        reverse(st);
        insertAtBottom(st, val);
    }

    public void insertAtBottom(Stack<Integer> st, int val) {
        if (st.isEmpty()) {
            st.push(val);
            return;
        }
        int cur = st.pop();
        insertAtBottom(st, val);
        st.push(cur);
    }
}
