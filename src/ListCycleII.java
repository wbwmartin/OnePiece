import Utils.ListNode;

//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//
//        Note: Do not modify the linked list.
//
//        Follow up:
//        Can you solve it without using extra space?

public class ListCycleII {

    // iterative, return cycle start node
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
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
        e.next = c;
        System.out.println(detectCycle(a).val); // 3
    }

}
