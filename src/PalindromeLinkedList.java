import Utils.ListNode;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode l1 = head;
        ListNode l2 = middle.next;
        while (l1 != null && l2 != null && l1.val == l2.val) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2 == null;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        System.out.println(isPalindrome(a)); // true
    }
}
