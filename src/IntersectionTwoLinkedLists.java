import Utils.ListNode;

//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//        For example, the following two linked lists:
//
//        A:          a1 → a2
//                            ↘
//                             c1 → c2 → c3
//                            ↗
//        B:     b1 → b2 → b3
//        begin to intersect at node c1.
//
//
//        Notes:
//
//        If the two linked lists have no intersection at all, return null.
//        The linked lists must retain their original structure after the function returns.
//        You may assume there are no cycles anywhere in the entire linked structure.
//        Your code should preferably run in O(n) time and use only O(1) memory.

public class IntersectionTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = detectCycle(headA);
        node.next = null;
        return result;
    }

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

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != null && l2 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            ListNode temp = headB;
            while (l2 != null) {
                l2 = l2.next;
                temp = temp.next;
            }
            headB = temp;
        }
        if (l1 != null) {
            ListNode temp = headA;
            while (l1 != null) {
                l1 = l1.next;
                temp = temp.next;
            }
            headA = temp;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    // unit test
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        a.next = b;
        ListNode res = getIntersectionNode(b, a);
        if (res == null) {
            System.out.println("null");
        } else {
            System.out.println(res.val);
        }
    }
}
