package Day5_LinkedList;

import Custom.Node;

public class MakeLinkedList {
    public Node solve(int a[]) {
        if (a == null || a.length < 1) return null;
        Node head = new Node(a[0]), list = head;
        for (int i = 1; i < a.length; i++) {
            head.next = new Node(a[i]);
            head = head.next;
        }
        return list;
    }
}
