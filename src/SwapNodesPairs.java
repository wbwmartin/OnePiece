import Utils.ListNode;

//Given a linked list, swap every two adjacent nodes and return its head.
//
//        For example,
//        Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//        Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

public class SwapNodesPairs {

    // iterative
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = prev.next; //head
            prev.next = head.next;
            head.next = temp;
            prev = head;
            head = head.next;
        }
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
        ListNode res = swapPairs(a);
        while (res != null) {
            System.out.print(res.val + " "); // 2 1 4 3 5
            res = res.next;
        }
    }

}
