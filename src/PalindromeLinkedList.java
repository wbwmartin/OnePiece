
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {  
            return true;  
        }  
        ListNode slow = head;
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = slow.next;
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        slow.next = null;
        while (head != null && prev != null) {
            if (head.val != prev.val) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;
    }
    
 // unit test
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
