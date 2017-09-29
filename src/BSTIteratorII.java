// Implement an iterator over a binary search tree (BST).
// Your iterator will be initialized with the root node of a BST.
//
//        Calling next() will return the next smallest number in the BST.
//
//        Note: next() and hasNext() should run in average O(1) time and
//           uses O(h) memory, where h is the height of the tree.
//   O(1) memory: morris inorder traversal

public class BSTIteratorII {

    TreeNode head;

    public BSTIteratorII(TreeNode root) {
        head = new TreeNode(0);
        TreeNode prev = null;
        TreeNode tail = new TreeNode(0);
        tail.right = head;
        while (root != null) {
            if (root.left == null) {
                if (head.right == null) {
                    head.right = root;

                }
                tail.right = root;
                tail = tail.right;
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                }
                if (prev.right == root) {
                    tail.right = root;
                    tail = tail.right;
                    root = root.right;
                }
            }
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return head.right != null;
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        head = head.right;
        return head;
    }
}
