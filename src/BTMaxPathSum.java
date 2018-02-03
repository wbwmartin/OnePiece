// Given a binary tree, find the maximum path sum.
//
//        For this problem, a path is defined as any sequence of nodes from
//          some starting node to any node in the tree along the parent-child
//          connections. The path must contain at least one node and does not
//          need to go through the root.
//
//        For example:
//        Given the below binary tree,
//
//        1
//        / \
//        2   3

import Utils.TreeNode;

public class BTMaxPathSum {

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = {Integer.MIN_VALUE};
        helper(root, res);
        return res[0];
    }

    private static int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int arc = left + right + root.val;
        int sum = Math.max(root.val, (Math.max(left, right) + root.val));
        res[0] = Math.max(res[0], Math.max(sum, arc));
        return sum;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(maxPathSum(a)); // 11
    }
}
