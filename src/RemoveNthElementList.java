import Utils.ListNode;

//Given a linked list, remove the nth node from the end of list and return its head.
//
//        For example,
//
//        Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.
//        Note:
//        Given n will always be valid.
//        Try to do this in one pass.

public class RemoveNthElementList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        while (n > 0) {
            head = head.next;
            n--;
        }
        while (head != null) {
            head = head.next;
            tail = tail.next;
        }
        tail.next = tail.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = removeNthFromEnd(a, 2);
        while (res != null) {
            System.out.print(res.val + " "); // 1 2 3 5
            res = res.next;
        }
    }

}
