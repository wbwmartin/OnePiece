import java.util.Stack;


public class BSTIterator {
	Stack<TreeNode> stack;
	
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        int result = temp.val;
        if (temp.right != null) {
            temp = temp.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}
