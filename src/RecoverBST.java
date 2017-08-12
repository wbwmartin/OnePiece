
public class RecoverBST {

    private static TreeNode first = null;
    private static TreeNode second = null;
    private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    // recursion, O(1) space
    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (first == null && root.val < prev.val) {
            first = prev;
        }
        if (first != null && root.val < prev.val) {
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
    
    // iterative, Morris
    public static void recoverTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode prev = null;
        TreeNode tail = null;
        while (root != null) {
            if (root.left == null) {
                if (tail != null && tail.val > root.val) {
                    if (node1 == null) {
                        node1 = tail;
                    }
                    node2 = root;
                }
                tail = root;
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == root) {
                    if (tail.val > root.val) {
                        if (node1 == null) {
                            node1 = tail;
                        }
                        node2 = root;
                    }
                    tail = root;
                    root = root.right;
                    prev.right = null;
                } else {
                    prev.right = root;
                    root = root.left;
                }
            }
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    
	// unit test
	public static void main(String[] args) {
		/*TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;	
		c.left = f;
		c.right = g;*/
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(1);
		a.right = b;
		b.left = c;
		recoverTree2(a);
		System.out.println(BTInorderTraversal.inorderTraversal(a)); // 1 2 3 4 5 6 7
	}
}
