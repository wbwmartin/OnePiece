import Utils.ListNode;

//Given a singly linked list L: L0?L1?…?Ln-1?Ln,
//        reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
//
//        You must do this in-place without altering the nodes' values.
//
//        For example,
//        Given {1,2,3,4}, reorder it to {1,4,2,3}.

public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode tail = reverseList(mid.next);
        mid.next = null;
        mergeLists(head, tail);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private static void mergeLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        while (l2 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        reorderList(a);
        while (a != null) {
            System.out.print(a.val + " "); // 1 4 2 3
            a = a.next;
        }
    }


}
