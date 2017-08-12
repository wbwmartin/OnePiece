package tripAdvisor;

public class RemoveFibonacciIndexList {
	
	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void remove(ListNode head) {
		int i1 = 0;
		int i2 = 1;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			for (int i = 0; i < i2 - 1; i++) {	
				head = head.next;
				fast = fast.next;
				if (fast == null) {
					return;
				}
			}
			fast = fast.next;
			head.next = fast.next;			
			int temp = i1;
			i1 = i2;
			i2 += temp;
		}
	}

	// unit test
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(5);
		ListNode g = new ListNode(6);
		ListNode h = new ListNode(7);
		ListNode i = new ListNode(8);
		ListNode j = new ListNode(9);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;

		remove(a);
		while (a != null) {
			System.out.print(a.val + " "); // 0 4 6 7 9
			a = a.next;
		}
	}
}
