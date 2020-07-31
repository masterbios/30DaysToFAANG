package Day05_LinkedList;

import Custom.Node;

public class MiddleOfLinkedList {
    public Node solve(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head, fast = head.next, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // return prev.next when n % 2 == 0 and return element of first half
        return slow;
    }
}
