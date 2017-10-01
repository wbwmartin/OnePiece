import Utils.TreeNode;

import java.util.List;

// Given an array where elements are sorted in ascending order,
// convert it to a height balanced BST.

public class ConvertSortedArrayBST {

    // recursive, binary search
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode res = sortedArrayToBST(nums);
        List<List<Integer>> list = BTLevelOrderTraversal.levelOrder(res); // 3 | 1 4 | 2 5
        for (List<Integer> i : list) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
