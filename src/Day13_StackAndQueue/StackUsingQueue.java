package Day13_StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue <T> {

    Queue<T> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    /****************** pop is costly*********/

    public void push1(T val) {
        queue.offer(val);
    }

    public T pop1() {
        int size = queue.size();
        for (int i = 1; i < size; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /******************************************/

    /****************** push is costly*********/

    public void push2(T val) {
        int size = queue.size();
        queue.offer(val);
        for (int i = 1; i <= size; i++) {
            queue.offer(queue.poll());
        }
    }

    public T pop2() {
        return queue.poll();
    }

    /******************************************/


    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.size() == 0;
    }
}
