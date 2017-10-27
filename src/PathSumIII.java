import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

//You are given a binary tree in which each node contains an integer value.
//
//        Find the number of paths that sum to a given value.
//
//        The path does not need to start or end at the root or a leaf, but it must go
//          downwards (traveling only from parent nodes to child nodes).
//
//        The tree has no more than 1,000 nodes and the values are in the range -1,000,000
//          to 1,000,000.
//
//        Example:
//
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//
//        Return 3. The paths that sum to 8 are:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3. -3 -> 11

public class PathSumIII {

    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private static int helper(TreeNode root, int cur, int target, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int res = map.getOrDefault(cur - target, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res += helper(root.left, cur, target, map) + helper(root.right, cur, target, map);
        map.put(cur, map.get(cur) - 1);
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;
        int res = pathSum(a, 8);
        System.out.println(res); // 3
    }

}
