package Day13_StackAndQueue;

import java.util.Stack;

public class CheckBalancedParanthesis {

    public void solve(String s) {
        System.out.println(check(s.toCharArray()));
    }

    private boolean check(char a[]) {
        Stack<Character> st = new Stack<>();
        for (char c : a) {
            if (isOpen(c)) {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char last = st.pop();
                if (!isValid(last, c)) return false;
            }
        }
        return st.isEmpty();
    }

    private boolean isOpen(char a) {
        if (a == '{' || a == '(' || a == '[') return true;
        return false;
    }

    private boolean isValid(char a, char b) {
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        return false;
    }
}
