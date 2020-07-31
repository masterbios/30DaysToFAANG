package Day13_StackAndQueue;

import java.util.Stack;

public class QueueUsingStack <T> {

    Stack<T> stack1;
    Stack<T> stack2;

    public QueueUsingStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /****************** add is costly*********/

    public void offer1(T val) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(val);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public T poll1() {
        return stack1.pop();
    }

    /******************************************/



    /****************** remove is costly*********/

    public void offer2(T val) {
        stack1.push(val);
    }

    public T poll2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /******************************************/

    public int size() {
        return stack1.size() + stack2.size();
    }

    public boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }
}
