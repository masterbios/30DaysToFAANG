package Day6_LinkedList;


import Custom.Node;

public class CopyListWithRandomPointer {
    public Node solve(Node head) {
        if (head == null) return null;
        Node cur = head;

        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }

        cur = head;

        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        cur = head;
        Node ans = cur.next, copy = cur.next;

        while (cur != null && copy != null) {
            if (cur.next != null) cur.next = cur.next.next;
            if (copy.next != null) copy.next = copy.next.next;
            cur = cur.next;
            copy = copy.next;
        }

        return ans;
    }
}
