import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//        For example:
//        Given binary tree [1,null,2,3],
//        1
//        \
//        2
//        /
//        3
//        return [1,3,2].
//
//        Note: Recursive solution is trivial, could you do it iteratively?

public class BTInorderTraversal {

    // recursive, dfs traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    // recursive, d & c
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> left = inorderTraversal2(root.left);
        List<Integer> right = inorderTraversal2(root.right);
        res.addAll(left);
        res.add(root.val);
        res.addAll(right);
        return res;
    }

    // iterative, stack
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            if (root.left != null) {
                root = root.left;
                stack.push(root);
            } else {
                TreeNode temp = stack.pop();
                res.add(temp.val);
                if (temp.right != null) {
                    root = temp.right;
                    stack.push(root);
                }
            }
        }
        return res;
    }

    // iterative, morris, O(1) space
    public static List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode prev = null;
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == root) {
                    prev.right = null;
                    res.add(root.val);
                    root = root.right;
                } else {
                    prev.right = root;
                    root = root.left;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(inorderTraversal4(a)); // 4 2 5 1 3
    }
}
