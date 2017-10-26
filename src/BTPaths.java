import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree, return all root-to-leaf paths.
//
//
//        Example
//        Given the following binary tree:
//
//        1
//        /   \
//        2     3
//        \
//        5
//        All root-to-leaf paths are:
//
//        [
//        "1->2->5",
//        "1->3"
//        ]

public class BTPaths {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        helper(root, String.valueOf(root.val), res);
        return res;
    }

    private static void helper(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }
        if (root.left != null) {
            helper(root.left, path + "->" + String.valueOf(root.left.val), res);
        }
        if (root.right != null) {
            helper(root.right, path + "->" + String.valueOf(root.right.val), res);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.right = d;
        List<String> res = binaryTreePaths(a);
        System.out.println(res); // [1->2->5, 1->3]
    }
}
