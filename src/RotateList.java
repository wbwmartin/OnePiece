import Utils.ListNode;

//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//        For example:
//        Given 1->2->3->4->5->NULL and k = 2,
//        return 4->5->1->2->3->NULL.

public class RotateList {

    // iterative
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        k = k % getLength(head);
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        fast = slow.next;
        slow.next = null;
        return fast;
    }

    private static int getLength(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
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
        ListNode res = rotateRight(a, 2);
        while (res != null) {
            System.out.print(res.val + " "); // 4 5 1 2 3
            res = res.next;
        }
    }

}

