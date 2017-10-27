import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//        For example,
//        Given n = 3, there are a total of 5 unique BST's.
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3

public class UniqueBST {

    // recursive, treenode list
    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> res = generateTrees(n);
    }
}
