
public class LCABST {

	// recursive
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
    
    // iterative
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    	if (root == null || p == null || q == null) {
    		return null;
    	}
    	if (p.val > q.val) {
    		TreeNode temp = p;
    		p = q;
    		q = temp;
    	}
    	while (root.val < p.val || root.val > q.val) {
    		if (root.val < p.val) {
    			root = root.right;
    		} else {
    			root = root.left;
    		}    		
    	}
    	return root;
    }
    
	// unit test
	public static void main(String[] args) {
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		TreeNode res = lowestCommonAncestor(a, d, e);
		System.out.println(res.val);
	}
}
