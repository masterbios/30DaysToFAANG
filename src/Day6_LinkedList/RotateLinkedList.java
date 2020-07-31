package Day6_LinkedList;

import Custom.Node;

public class RotateLinkedList {
    public Node antiClock(Node head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        Node cur = head;
        int cnt = 0;

        while (cnt < k - 1 && cur != null) {
            cur = cur.next;
            cnt++;
        }

        Node kth = cur;

        while (cur.next != null) cur = cur.next;

        cur.next = head;
        head = kth.next;
        kth.next = null;

        return head;
    }

    public Node clock(Node head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        Node cur = head;
        int len = 0, cnt = 0;

        while (cur != null) { cur = cur.next; len++; }

        if (k >= len) k = len - k;

        cur = head;

        while (cnt < k - 1 && cur != null) {
            cur = cur.next;
            cnt++;
        }
        Node kth = cur.next;
        while (cur.next != null) cur = cur.next;

        cur.next = head;
        head = kth.next;
        kth.next = null;

        return head;
    }

    public void print(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
