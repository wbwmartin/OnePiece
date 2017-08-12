
public class ReorderList {
	
	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// 
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode tail = reverseList(mid.next);
        mid.next = null;
        mergeLists(head, tail);
    }
    
    private static ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
	
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private static void mergeLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        while (l2 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }
        if (l1 != null) {
            head.next = l1;
        }
    } 
}
