//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//        An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//        Find the total sum of all root-to-leaf numbers.
//
//        For example,
//
//        1
//        / \
//        2   3
//        The root-to-leaf path 1->2 represents the number 12.
//        The root-to-leaf path 1->3 represents the number 13.
//
//        Return the sum = 12 + 13 = 25.

import Utils.TreeNode;

public class SumRootLeafNumbers {

    // recursive
    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private static int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = root.val + sum * 10;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
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
        System.out.println(sumNumbers(a)); // 262
    }
}
