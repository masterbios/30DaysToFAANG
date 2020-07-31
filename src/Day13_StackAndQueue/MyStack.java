package Day13_StackAndQueue;

public class MyStack <T extends Object> {

    final int DEFAULT_SIZE = 16;

    private int size;
    private int top;
    private T[] stack;

    public MyStack() {
        this.top = -1;
        this.size = DEFAULT_SIZE;
        this.stack = (T[]) new Object[size];
    }

    public MyStack(int size) {
        this.size = size;
        this.top = -1;
        this.stack = (T[]) new Object[size];
    }

    public void push(T val) {
        if (this.isFull()) {
            this.increaseSize();
        }
        this.stack[++top] = val;
    }

    public T pop() {
        if (this.isEmpty()) throw new NullPointerException("stack is empty");
        T val = stack[top--];
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new NullPointerException("stack is empty");
        return stack[top];
    }

    public void increaseSize() {
        T[] newstack = (T[]) new Object[this.size * 2];
        for (int i = 0; i < this.size; i++) newstack[i] = stack[i];
        this.stack = newstack;
        this.size = this.size * 2;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == this.size - 1;
    }
}
