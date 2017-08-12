import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderTraversal {

	// recursive, dfs traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
    
    private static void helper(List<Integer> res, TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	helper(res, root.left);
    	res.add(root.val);
    	helper(res, root.right);
    }
    
    // recursive, d & c
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        List<Integer> left = inorderTraversal2(root.left);
        List<Integer> right = inorderTraversal2(root.right);       
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }
    
    // iterative, stack
    public static List<Integer> inorderTraversal3(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
        	if (root.left != null) {
        		root = root.left;
        		stack.push(root);        		
        	} else {
        		TreeNode temp = stack.pop();
        		res.add(temp.val);
        		if (temp.right != null) {
        			root = temp.right;
        			stack.push(root);      			
        		}
        	}
        }
        return res;
    }
    
    // iterative, morris, O(1) space
    public static List<Integer> inorderTraversal4(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        TreeNode prev = null;
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == root) {
                    prev.right = null;
                    res.add(root.val);
                    root = root.right;
                } else {
                    prev.right = root;
                    root = root.left;
                }
            }
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

		List<Integer> res = inorderTraversal4(a);
		for (Integer i: res) {
			System.out.println(i);
		}
	}
}
