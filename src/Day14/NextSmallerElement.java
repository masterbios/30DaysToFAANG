package Day14;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {

    public void solve(int a[]) {
        int n = a.length;
        int ans[] = new int[n];
        ans[n - 1] = -1;
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) st.pop();
            if (!st.isEmpty()) ans[i] = a[st.peek()];
            else ans[i] = -1;
            st.push(i);
        }
        System.out.println(Arrays.toString(ans));
    }
}
