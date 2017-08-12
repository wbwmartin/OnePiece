
public class RotateList {
	
	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	// iterative
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        k = k % getLength(head);
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        fast = slow.next;
        slow.next = null;
        return fast;
    }
    
    private static int getLength(ListNode head) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
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
		ListNode res = rotateRight(a, 2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}
	
}

