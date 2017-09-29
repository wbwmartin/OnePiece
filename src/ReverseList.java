import Utils.ListNode;

//Reverse a singly linked list.
//
//        Hint:
//        A linked list can be reversed either iteratively or recursively.
//          Could you implement both?

public class ReverseList {

    // iterative
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        return helper(head, null);
    }

    private static ListNode helper(ListNode head, ListNode prev) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        head.next = prev;
        return helper(next, head);
    }

    // unit test
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
        ListNode res = reverseList(a);
        while (res != null) {
            System.out.print(res.val + " "); // 5 4 3 2 1
            res = res.next;
        }
    }

}
