package Day14;

public class SpecialStack {
    int size;
    Node head, mid;

    public SpecialStack() {
        this.size = 0;
    }

    public void push(int val) {
        Node temp = new Node(val);
        temp.next = head;
        size++;
        if (size == 1) {
            mid = temp;
        } else {
            head.prev = temp;
            if (size % 2 != 0) {
                mid = mid.prev;
            }
        }
        head = temp;
    }

    public int pop() {
        if (size == 0) return -1;
        int ans = head.val;
        head = head.next;

        // important line
        if (head != null) head.prev = null;

        size--;
        if (size % 2 == 0) {
            mid = mid.next;
        }
        return ans;
    }

    public int getMid() {
        if (size == 0) return -1;
        return mid.val;
    }


    class Node {
        Node next,prev;
        int val;
        public Node(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }


}
