import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {

    public static int[] twoSum(TreeNode root, int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int[] res = new int[2];
        if (list.size() < 2) {
            return null;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == n) {
                res[0] = list.get(left);
                res[1] = list.get(right);
                return res;
            } else if (sum < n) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(5);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        int[] res = twoSum(a, 3);
        System.out.println(res[0] + " " + res[1]); // 1 2
    }

}
