import Utils.ListNode;

//Remove all elements from a linked list of integers that have value val.
//
//        Example
//        Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//        Return: 1 --> 2 --> 3 --> 4 --> 5

public class RemoveListElements {

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = removeElements(a, 2);
        while (res != null) {
            System.out.print(res.val + " "); // 1 3 4
            res = res.next;
        }
    }

}
