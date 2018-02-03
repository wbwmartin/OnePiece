import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// Given two binary trees, write a function to check if they are equal or not.
//
//        Two binary trees are considered equal if they are structurally identical and
//          the nodes have the same value.

public class SameTree {

    // recursive
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    // iterative bfs
    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }
            q1.offer(t1.left);
            q1.offer(t1.right);
            q2.offer(t2.left);
            q2.offer(t2.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        TreeNode a2 = TreeNode.createBT();
        System.out.println(isSameTree(a, a2)); // true
        System.out.println(isSameTree2(a, a2)); // true
    }

}

