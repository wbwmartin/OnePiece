//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//        For example,
//        Given 1->1->2, return 1->2.
//        Given 1->1->2->3->3, return 1->2->3.

import Utils.ListNode;

public class RemoveDupSortedList {

    // iteration
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        ListNode res = deleteDuplicates(a);
        while (res != null) {
            System.out.print(res.val + " "); // 1 2
            res = res.next;
        }
    }

}
