import java.util.Stack;

public class MaxTree {

	public static TreeNode maxTree(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		for (int i = 0; i <= A.length; i++) {
			TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
					: new TreeNode(A[i]);
			while (!stack.empty()) {
				if (right.val < stack.peek().val) {
					break;
				}
				TreeNode cur = stack.pop();
				if (stack.empty()) {
					right.left = cur;
				} else {
					TreeNode left = stack.peek();
					if (left.val < right.val) {
						left.right = cur;
					} else {
						right.left = cur;
					}
				}
			}
			stack.push(right);
		}
		return stack.peek().left;
	}
}
