// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root
// node down to the nearest leaf node.

import Utils.TreeNode;

public class MinDepthBT {

    // recursive, d & c
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    private static int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    // recursive, dfs
    public static int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth2(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth2(root.left) + 1;
        }
        return Math.min(minDepth2(root.left), minDepth(root.right)) + 1;
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
        System.out.println(minDepth2(a)); // 2
    }

}


