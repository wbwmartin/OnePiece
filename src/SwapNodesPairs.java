
public class SwapNodesPairs {

	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	// iterative
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = prev.next; //head
            prev.next = head.next;
            head.next = temp;
            prev = head;
            head = head.next;
        }
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
		ListNode res = swapPairs(a);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
