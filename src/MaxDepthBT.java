//Given a binary tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node
// down to the farthest leaf node.

import Utils.TreeNode;

public class MaxDepthBT {

    // recursive, d & c
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(maxDepth(a)); // 3
    }

}

