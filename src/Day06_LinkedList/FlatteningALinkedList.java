package Day06_LinkedList;

import Custom.Node1;

public class FlatteningALinkedList {
    public Node1 solve(Node1 head) {
        if (head == null || head.right == null) return head;
        head.right = solve(head.right);
        head = merge(head, head.right);
        return head;
    }

    public Node1 merge(Node1 a, Node1 b) {
        if (a == null) return b;
        if (b == null) return a;
        Node1 result = null;
        if (a.val < b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        result.right = null;
        return result;
    }

    public void print(Node1 head) {
        if (head == null) return;
        Node1 cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.down;
        }
        System.out.println();
    }

}
