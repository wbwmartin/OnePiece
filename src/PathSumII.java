import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//        For example:
//        Given the below binary tree and sum = 22,
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        return
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]

public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> item = new ArrayList<>();
        helper(res, item, root, sum);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> item, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            List<Integer> temp = new ArrayList<>(item);
            temp.add(root.val);
            res.add(temp);
            return;
        }
        item.add(root.val);
        helper(res, item, root.left, sum);
        helper(res, item, root.right, sum);
        item.remove(item.size() - 1);
    }

    // unit test
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
        List<List<Integer>> res = pathSum(a, 7);
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " "); // 1 2 4
            }
            System.out.print("\n");
        }
    }
}
