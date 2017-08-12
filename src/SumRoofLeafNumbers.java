
public class SumRoofLeafNumbers {

	// recursive
    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private static int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = root.val + sum * 10;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
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
		System.out.println(sumNumbers(a));
	}
}
