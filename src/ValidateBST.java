import java.util.Stack;

public class ValidateBST {
	
	// morris
	public static boolean isValidBST0(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        TreeNode prev = null;
        long tail = Long.MIN_VALUE;
        while (root != null) {
            if (root.left == null) {
                if (tail >= root.val) {
                    return false;
                }
                tail = root.val;
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == root) {
                    if (tail >= root.val) {
                        return false;
                    }
                    prev.right = null;
                    tail = root.val;
                    root = root.right;
                } else {
                    prev.right = root;
                    root = root.left;
                }
            }
        }
        return true;
    }
	
	// iterative
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        long prev = Long.MIN_VALUE;
        while (!stack.isEmpty()) {
            if (root.left != null) {
                root = root.left;
                stack.push(root);
            } else {
                TreeNode temp = stack.pop();
                if (prev >= temp.val) {
                    return false;
                }
                prev = temp.val;
                if (temp.right != null) {
                    root = temp.right;
                    stack.push(root);
                }
            }
        }
        return true;
    }
    
    // recursive, bound
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static boolean helper(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (low >= root.val || root.val >= high) {
            return false;
        }
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
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
		System.out.println(isValidBST0(a));
	}
}
