import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given a binary tree, return the preorder traversal of its nodes' values.
//
//        For example:
//        Given binary tree {1,#,2,3},
//        1
//        \
//        2
//        /
//        3
//        return [1,2,3].
//
//        Note: Recursive solution is trivial, could you do it iteratively?

public class BTPreorderTraversal {

    // recursive, dfs traversal
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    // recursive, d & c
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        List<Integer> left = preorderTraversal2(root.left);
        List<Integer> right = preorderTraversal2(root.right);
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
    }

    // iterative, stack
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;
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
        List<Integer> res = preorderTraversal3(a);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

}
