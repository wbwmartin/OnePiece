//Given a binary tree, find the maximum path sum from root.
//
//        The path may end at any node in the tree and contain at least one node in it.
//
//        Example
//        Given the below binary tree:
//
//        1
//        / \
//        2   3
//        return 4. (1->3)

import Utils.TreeNode;

public class BTMaxPathSumII {

    public static int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return Math.max(root.val, (Math.max(left, right) + root.val));
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(maxPathSum2(a)); // 8
    }

}
