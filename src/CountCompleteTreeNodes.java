//Given a complete binary tree, count the number of nodes.
//
//        Definition of a complete binary tree from Wikipedia:
//        In a complete binary tree every level, except possibly the last,
// is completely filled, and all nodes in the last level are as far left as possible.
// It can have between 1 and 2h nodes inclusive at the last level h.

import Utils.TreeNode;

public class CountCompleteTreeNodes {

    // recursive, binary search
    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root, true);
        int right = getDepth(root, false);
        if (left == right) {
            return (1 << left) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static int getDepth(TreeNode root, boolean isLeft) {
        int res = 0;
        while (root != null) {
            res++;
            if (isLeft) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(countNodes(a)); // 5
    }
}
