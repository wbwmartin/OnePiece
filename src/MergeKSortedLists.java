import Utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Merge k sorted linked lists and return it as one sorted list.
//
//        Analyze and describe its complexity.
//
//
//        Example
//        Given lists:
//
//        [
//        2->4->null,
//        null,
//        -1->null
//        ],
//        return -1->2->4->null.

public class MergeKSortedLists {

    // binary search, O(nklogk) time
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private static ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        return dummy.next;
    }

    // merge K lists, heap, O(n) space, O(nklogk) time
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        Queue<ListNode> pq = new PriorityQueue<>(k, Comparator.comparing((ListNode node) -> node.val));
        for (int i = 0; i < k; i++) {
            ListNode node = lists[i];
            if (node != null) {
                pq.offer(node);
                lists[i] = node.next;
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(8);
        ListNode g = new ListNode(3);
        ListNode h = new ListNode(6);
        ListNode i = new ListNode(9);
        a.next = b;
        b.next = c;
        d.next = e;
        e.next = f;
        g.next = h;
        h.next = i;
        ListNode[] lists = {a, d, g};
        ListNode res = mergeKLists2(lists);
        while (res != null) {
            System.out.print(res.val + " "); // 1 2 3 4 5 6 7 8 9
            res = res.next;
        }
    }

}
