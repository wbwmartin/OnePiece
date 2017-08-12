
public class IntersectionTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
