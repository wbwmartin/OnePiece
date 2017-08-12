
public class PartitionList {

	// data structure
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// memory limit exceeded
    public static ListNode partition0(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = head;
        while (head.val < 3) {
            if (head.next == null) {
                return dummy.next;
            }
            a = head;
            head = head.next;
        }
        ListNode b = head, c = head;
        while (head != null) {
        	if (head.val >= x) {
        		c = head;
        		head = head.next;       		
        	} else {
        		ListNode temp = head.next;
        		head.next = b;
        		a.next = head;
        		head = temp;
        		c.next = head;
        	}
        }
        return dummy.next;
    }
    
    public static ListNode partition(ListNode head, int x) {
    	if (head == null) {
    		return null;
    	}
    	ListNode leftDummy = new ListNode(0);
    	ListNode rightDummy = new ListNode(0);
    	ListNode left = leftDummy, right = rightDummy;
    	while (head != null) {
    		if (head.val < x) {
    			left.next = head;
    			left = head;
    		} else {
    			right.next = head;
    			right = head;
    		}
    		head = head.next;
    	}
    	left.next = rightDummy.next;
    	right.next = null;
    	return leftDummy.next;
    }
	
	// unit test
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		ListNode res = partition(a, 3);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
