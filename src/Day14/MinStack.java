package Day14;

import java.util.Stack;

public class MinStack {

    Stack<Integer> st;
    Stack<Integer> min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int val) {
        int ans = Math.min(this.min.peek(), val);
        this.st.push(val);
        this.min.push(ans);
    }

    public int pop() {
        this.min.pop();
        return this.st.pop();
    }

    public int getMin() {
        return this.min.peek();
    }

    public boolean isEmpty() {
        return this.st.size() == 0;
    }
}
