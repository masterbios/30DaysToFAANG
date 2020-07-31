package Day14;

import java.util.Stack;

public class LargestRectangleInAHistogram {
    public void solve(int a[]) {
        System.out.println(go(a));
    }

    // find small on left and right side
    // default value of left is -1;
    // default value of right is n
    public int go(int a[]) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        int left[] = new int[n], right[] = new int[n];
        left[0] = -1; right[n - 1] = n;

        st.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) st.pop();
            if (!st.isEmpty()) right[i] = st.peek();
            else right[i] = n;
            st.push(i);
        }

        st.clear();
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            if (!st.isEmpty()) left[i] = st.peek();
            else left[i] = -1;
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * a[i]);
        }
        return ans;
    }
}
