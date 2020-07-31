package Day06_LinkedList;

import Custom.Node;

public class InteresectionPointOfYLinkedList {
    public Node solve(Node list1, Node list2) {
        if (list1 == null || list2 == null) return null;
        int size1 = getSize(list1), size2 = getSize(list2);
        if (size2 > size1) {
            Node temp = list1;
            list1 = list2;
            list2 = temp;
            size1 ^= size2;
            size2 ^= size1;
            size1 ^= size2;
        }
        Node ptr1 = list1, ptr2 = list2;
        for (int i = 0; i < size1 - size2; i++) {
            ptr1 = ptr1.next;
        }
        while (ptr1 != null && ptr2 != null) {
            if (ptr1 == ptr2) return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }

    public int getSize(Node head) {
        if (head == null) return 0;
        Node cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
}
