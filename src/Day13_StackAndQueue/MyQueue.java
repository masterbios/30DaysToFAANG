package Day13_StackAndQueue;

public class MyQueue <T> {

    Node front;
    Node rear;

    public MyQueue() {
        this.front = this.rear = null;
    }

    public void offer(T val) {
        Node temp = new Node(val);
        if (front == null) {
            front = rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
    }

    public T poll() {
        if (isEmpty()) throw new NullPointerException("Queue is empty");
        Node temp = front;
        front = front.next;
        return temp.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void print() {
        Node cur = front;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    class Node {
        T val;
        Node next;
        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }
}
