import Utils.ListNode;

//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//        For example:
//        Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//        return 1->4->3->2->5->NULL.
//
//        Note:
//        Given m, n satisfy the following condition:
//        1 ≤ m ≤ n ≤ length of list.

public class ReverseListII {

    // partially reverse, iterative
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m > n || head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode prev = head, mNode = head.next;
        ListNode nNode = mNode, post = mNode.next;
        for (int i = m; i < n; i++) {
            if (post == null) {
                return null;
            }
            ListNode temp = post.next;
            post.next = nNode;
            nNode = post;
            post = temp;
        }
        prev.next = nNode;
        mNode.next = post;

        return dummy.next;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = null;
        head = dummy;
        int index = 1;
        while (index < m) {
            cur = cur.next;
            head = head.next;
            index++;
        }
        while (index <= n) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            index++;
        }
        head.next.next = cur;
        head.next = pre;
        return dummy.next;
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
        ListNode res = reverseBetween(a, 2, 4);
        while (res != null) {
            System.out.print(res.val + " "); // 1 4 3 2 5
            res = res.next;
        }
    }
}
