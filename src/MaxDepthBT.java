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
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        System.out.println(maxDepth(a)); // 3
    }

}

