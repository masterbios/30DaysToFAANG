package Day13_StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public void solve(int a[]) {
        int n = a.length;
        int ans[] = new int[n];
        ans[n - 1] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] <= a[i]) st.pop();
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = a[st.peek()];
            st.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
