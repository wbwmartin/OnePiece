
public class ReverseList {

	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// iterative
	public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
	
	// recursive
	public static ListNode reverseList2(ListNode head) {
		return null;
	}
	
	// partially reverse, iterative
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m > n || head == null) {
			return null;
		}
		ListNode dummy  = new ListNode(0);
		dummy.next =  head;
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
			System.out.println(res.val);
			res = res.next;
		}
	}

}
