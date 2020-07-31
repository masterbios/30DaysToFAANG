package Day5_LinkedList;

import Custom.Node;

public class AddTwoNumberasLinkedList {

    public void solve(Node list1, Node list2) {
        // call anymethod from here
    }

    Node ans, cur;
    int carry;

    // example = 123 + 456
    // list is A[1,2,4] B[4,5,6]
    private Node whenListisNotReverse(Node list1, Node list2) {
        this.ans = this.cur = null;
        this.carry = 0;
        go(list1, list2);
        return ans;
    }

    private void go(Node list1, Node list2) {
        if (list1 == null) { ans = list2; return; }
        if (list2 == null) { ans = list1; return; }

        int size1 = getSize(list1), size2 = getSize(list2);

        if (size1 == size2) {
            addSameSize(list1, list2);
        } else {
            if (size1 < size2) {
                int rep = size1; size1 = size2; size2 = rep;
                Node temp = list1; list1 = list2; list2 = temp;
            }
            int diff = size1 - size2;
            this.cur = list1;
            while (diff > 0) { cur = cur.next; diff--; }
            addSameSize(cur, list2);
            propogateCarry(list1);
        }
        if (this.carry > 0) {
            Node newnode = new Node(this.carry);
            newnode.next = ans;
            ans = newnode;
        }
    }

    private int getSize(Node cur) {
        if (cur == null) return 0;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    private void addSameSize(Node list1, Node list2) {
        if (list1 == null) return;

        addSameSize(list1.next, list2.next);

        int sum = list1.val + list2.val + this.carry;
        this.carry = sum / 10;
        sum %= 10;

        Node newnode = new Node(sum);
        newnode.next = ans;
        ans = newnode;
    }

    private void propogateCarry(Node list) {
        while (list != this.cur) {
            propogateCarry(list.next);
            int sum = list.val + this.carry;
            this.carry = sum / 10;
            sum %= 10;
            Node newnode = new Node(sum);
            newnode.next = ans;
            ans = newnode;
        }
    }

    // example = 123 + 456
    // list is A[3,2,1] B[6,5,4]
    private Node whenListisReverese(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        Node dummy = new Node(-1), ans = dummy;
        Node ptr1 = list1, ptr2 = list2;
        int carry = 0, sum = 0;
        while (ptr1 != null || ptr2 != null) {
            sum = 0;
            if (ptr1 != null) sum += ptr1.val;
            if (ptr2 != null) sum += ptr2.val;
            sum += carry;
            System.out.println(sum + " " + carry);
            carry = 0;
            dummy.next = new Node(sum % 10);
            sum /= 10;
            carry = sum;
            if (ptr1 != null) ptr1 = ptr1.next;
            if (ptr2 != null ) ptr2 = ptr2.next;
            dummy = dummy.next;
        }
        if (carry > 0) {
            dummy.next = new Node(carry);
        }
        return ans.next;
    }

    public void print(Node head) {
        if (head == null) return;
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

}
