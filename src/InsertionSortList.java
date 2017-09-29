// Sort a linked list using insertion sort.

import Utils.ListNode;

public class InsertionSortList {

    // iterative
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = insertionSortList(a);
        while (res != null) {
            System.out.print(res.val + " "); // 1 2 3 4 5
            res = res.next;
        }
    }
}
