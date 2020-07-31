package Day5_LinkedList;

import Custom.Node;

public class RemoveNthNodeFromBack {
    public Node solve(Node head, int n) {
        if (head == null || n == 0) return head;
        Node ptr1 = head, ptr2 = head, ans = head;
        for (int i = 0; i < n; i++) {
            if (ptr2.next == null) {
                if (i == n - 1) {
                    head = head.next;
                    return head;
                }
            }
            ptr2 = ptr2.next;
        }
        while (ptr2.next != null) {
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }
        ptr1.next = ptr1.next.next;
        return ans;
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
