

public class BTMaxPathSum {

	// recursive, d & c
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = {Integer.MIN_VALUE};
        helper(root, res);
        return res[0];
    }
    
    private static int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int arc = left + right + root.val;
        int sum = Math.max(root.val, (Math.max(left, right) + root.val));
        res[0] = Math.max(res[0], Math.max(sum, arc));
        return sum;
    }
    
    // unit test
 	public static void main(String[] args) {
 		TreeNode a = new TreeNode(1);
 		TreeNode b = new TreeNode(2);
 		TreeNode c = new TreeNode(3);
 		TreeNode d = new TreeNode(4);
 		TreeNode e = new TreeNode(5);
 		a.left = b;
 		a.right = c;
 		b.left = d;
 		b.right = e;

 		System.out.println(maxPathSum(a)); // 11
 	}
}
