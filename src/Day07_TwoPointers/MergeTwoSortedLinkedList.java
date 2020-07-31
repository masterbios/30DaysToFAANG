package Day07_TwoPointers;

import Custom.Node;

public class MergeTwoSortedLinkedList {
    public Node iterative(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node dummy = new Node(-1), ans = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        if (head1 != null) dummy.next = head1;
        if (head2 != null) dummy.next = head2;
        return ans.next;
    }

    public Node recursive(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.val <= head2.val) {
            head1.next = recursive(head1.next, head2);
            return head1;
        } else {
            head2.next = recursive(head1, head2.next);
            return head2;
        }
    }

    public static void print(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

}
