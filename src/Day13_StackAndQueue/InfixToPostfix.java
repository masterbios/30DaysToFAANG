package Day13_StackAndQueue;

import java.util.Stack;

public class InfixToPostfix {

    // time complexity : O(N)
    // space complexity : O(N)

    public void solve(String s) {
        System.out.println(convertInfixToPostfix(s));
    }

    private String convertInfixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { // abc123
                sb.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') sb.append(st.pop());
                if (!st.isEmpty() && st.peek() != '(') return "invalid";
                st.pop();
            } else { // + - * / ^ handle precedence
                while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    if (st.peek() == '(') return "invalid";
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }

        return sb.toString();
    }

    private int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else if (c == '^') return 3;
        else return -1;
    }
}
