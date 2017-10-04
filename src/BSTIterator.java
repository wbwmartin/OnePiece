import Utils.TreeNode;

import java.util.Stack;

// Implement an iterator over a binary search tree (BST).
// Your iterator will be initialized with the root node of a BST.
//
//        Calling next() will return the next smallest number in the BST.
//
//        Note: next() and hasNext() should run in average O(1) time and
//           uses O(h) memory, where h is the height of the tree.


public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addNodeToStack(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.empty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            addNodeToStack(node);
        }
        return result;
    }

    private void addNodeToStack(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
