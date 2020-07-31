package Day5_LinkedList;

import Custom.Node;

public class ReverseLinkedList {
    public Node solve(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public void print(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
