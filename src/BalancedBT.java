//Given a binary tree, determine if it is height-balanced.
//
//		For this problem, a height-balanced binary tree is defined as a binary tree
// in which the depth of the two subtrees of every node never differ by more than 1.

import Utils.TreeNode;

public class BalancedBT {

    // recursive
    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(isBalanced(a)); // true
    }
}
