
public class CountCompleteTreeNodes {

	// recursive, binary search
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLeft(root);
        int right = getRight(root);
        if (left == right) {
            return (1 << left) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private static int getLeft(TreeNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.left;
        }
        return res;
    }
    
    private static int getRight(TreeNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.right;
        }
        return res;
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
		System.out.println(countNodes(a));
    }
}
