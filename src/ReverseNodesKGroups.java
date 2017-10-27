import Utils.ListNode;

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//        k is a positive integer and is less than or equal to the length of the linked list.
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//        You may not alter the values in the nodes, only nodes itself may be changed.
//
//        Only constant memory is allowed.
//
//        For example,
//        Given this linked list: 1->2->3->4->5
//
//        For k = 2, you should return: 2->1->4->3->5
//
//        For k = 3, you should return: 3->2->1->4->5


public class ReverseNodesKGroups {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int len = getLength(head);
        int times = len / k;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode prev = null;
        ListNode tail = cur;
        head = dummy;
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < k; j++) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }
            head.next = prev;
            head = tail;
            tail = cur;
            prev = null;
        }
        head.next = cur;
        return dummy.next;
    }

    private static int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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
        ListNode res = reverseKGroup(a, 3);
        while (res != null) {
            System.out.print(res.val + " "); // 3 2 1 4 5
            res = res.next;
        }
    }
}
