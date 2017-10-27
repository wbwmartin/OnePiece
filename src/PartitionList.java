import Utils.ListNode;

// Given a linked list and a value x,partition it such that all nodes less than x come
// before nodes greater than or equal to x.
//
//        You should preserve the original relative order of the nodes in each of the
//          two partitions.
//
//        For example,
//        Given 1->4->3->2->5->2and x=3,
//        return 1->2->2->4->3->5.

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        left.next = rightDummy.next;
        right.next = null;
        return leftDummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = partition(a, 3);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
