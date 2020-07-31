package Day05_LinkedList;

import Custom.Node;

public class MergeTwoSortedLinkedList {
    public Node solve(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        Node ans = new Node(-1), head = ans;
        Node ptr1 = list1, ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                ans.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                ans.next = ptr2;
                ptr2 = ptr2.next;
            }
            ans = ans.next;
        }
        if (ptr1 != null) ans.next = ptr1;
        if (ptr2 != null) ans.next = ptr2;

        return head.next;
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
