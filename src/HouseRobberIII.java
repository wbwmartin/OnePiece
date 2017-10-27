// The thief has found himself a new place for his thievery again.
// There is only one entrance to this area, called the "root."
// Besides the root, each house has one and only one parent house.
// After a tour, the smart thief realized that "all houses in this place
// forms a binary tree". It will automatically contact the police if two
// directly-linked houses were broken into on the same night.
//
//        Determine the maximum amount of money the thief can rob tonight without alerting the police.

// Example 1:
//        3
//        / \
//        2   3
//        \   \
//        3   1
//        Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
// Example 2:
//        3
//        / \
//        4   5
//        / \   \
//        1   3   1
//        Maximum amount of money the thief can rob = 4 + 5 = 9.

import Utils.TreeNode;

public class HouseRobberIII {

    public static int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        System.out.println(rob(a)); // 9
    }

}
