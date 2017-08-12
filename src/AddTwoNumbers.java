
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int carry = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
    
    // unit test
    public static void main(String[] args) {
    	ListNode a = new ListNode(2);
    	ListNode b = new ListNode(4);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(5);
    	ListNode e = new ListNode(6);
    	ListNode f = new ListNode(4);
    	a.next = b;
    	b.next = c;
    	d.next = e;
    	e.next = f;
    	ListNode res = addTwoNumbers(a, d);
    	while (res != null) {
			System.out.println(res.val); // 7 0 8
			res = res.next;
		}
    }
}
