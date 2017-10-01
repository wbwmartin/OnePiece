import Utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// Given a binary tree, return the postorder traversal of its nodes' values.
//
//		For example:
//		Given binary tree {1,#,2,3},
//		1
//		\
//		2
//		/
//		3
//		return [3,2,1].
//
//		Note: Recursive solution is trivial, could you do it iteratively?

public class BTPostorderTraversal {

    // recursive, dfs traversal
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    // recursive, d & c
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> left = postorderTraversal2(root.left);
        List<Integer> right = postorderTraversal2(root.right);
        res.addAll(left);
        res.addAll(right);
        res.add(root.val);
        return res;
    }

    // iterative, two stack
    public static List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) {
                s1.push(temp.left);
            }
            if (temp.right != null) {
                s1.push(temp.right);
            }
        }
        while (!s2.empty()) {
            res.add(s2.pop().val);
        }
        return res;
    }

    // iterative, similar to pre-order, reverse order
    public static List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    // iterative, 1 stack
    public static List<Integer> postorderTraversal5(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = root;
        while (!stack.empty()) {
            TreeNode cur = stack.peek();
            if (cur.left == null && cur.right == null || cur.left == prev || cur.right == prev) {
                res.add(cur.val);
                stack.pop();
                prev = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
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
        List<Integer> res = postorderTraversal5(a); // 4 5 2 3 1
        for (Integer i : res) {
            System.out.println(i);
        }
    }

}
