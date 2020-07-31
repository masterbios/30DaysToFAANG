package Day06_LinkedList;

import Custom.Node;

public class DetectACycleAndRemove {

    public boolean solve(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == slow) {
            slow = head;
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
            slow = head;
            while (slow != null) {
                System.out.print(slow.val + " ");
                slow = slow.next;
            }
            System.out.println();
            return true;
        }
        return false;
    }

    public void removeLoop(Node head, Node ptr) {

    }
}
