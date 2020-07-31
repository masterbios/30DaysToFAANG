package Day7_TwoPointers;

import Custom.Node;

public class FindStartingPointOfLoop {
    public Node solve(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) break;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == slow) {
            slow = head;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    public Node solve2(Node head) {
        if (head == null || head.next == null) return null;
        Node dummy = new Node(9999999);
        Node cur = head;
        while (cur != null) {
            if (cur.next == dummy) return cur;
            Node next = cur.next;
            cur.next = dummy;
            cur = next;
        }
        return null;
    }
}
