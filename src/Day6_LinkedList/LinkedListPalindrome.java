package Day6_LinkedList;

import Custom.Node;

public class LinkedListPalindrome {
    public boolean solve(Node head) {
        if (head == null || head.next == null) return true;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node ptr1 = head, ptr2 = reverse(slow.next);
        slow.next = null;
        while (ptr2 != null) {
            if (ptr1.val != ptr2.val) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node cur = head, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
