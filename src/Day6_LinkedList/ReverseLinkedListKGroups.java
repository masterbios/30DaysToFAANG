package Day6_LinkedList;

import Custom.Node;

import java.util.Stack;

public class ReverseLinkedListKGroups {
    public Node recursive(Node head, int k) {
        if (head == null || k <= 1) return head;
        Node cur = head, next = null, prev = null;
        int count = 0;
        while (count < k && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
        if (next != null) head.next = recursive(next, k);
        return prev;
    }

    public Node iterative(Node head, int k) {
        if (head == null || k <= 1) return head;
        Node cur = head, prev = null;
        Stack<Node> st = new Stack<>();

        while (cur != null) {
            int cnt = 0;
            while (cnt < k && cur != null) {
                st.push(cur);
                cur = cur.next;
                cnt++;
            }
            while (!st.isEmpty()) {
                if (prev == null) {
                    prev = st.pop();
                    head = prev;
                } else {
                    prev.next = st.pop();
                    prev = prev.next;
                }
            }
        }
        prev.next = null;
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
