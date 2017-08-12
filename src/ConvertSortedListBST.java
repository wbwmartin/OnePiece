import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListBST {

	// recursive, binary search
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<Integer>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return helper(nums, 0, nums.size() - 1);
    }
    
    private static TreeNode helper(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
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
		TreeNode res = sortedListToBST(a);
		List<List<Integer>> list = BTLevelOrderTraversal.levelOrder(res);
    	for (List<Integer> i: list) {
			for (Integer j: i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
    }
}
