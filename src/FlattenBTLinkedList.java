// Given a binary tree, flatten it to a linked list in-place.
//
//        For example,
//        Given
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        The flattened tree should look like:
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
//
//        Hints:
//        If you notice carefully in the flattened tree,
//        each node's right child points to the next node of a pre-order traversal.

import Utils.TreeNode;

public class FlattenBTLinkedList {

    static TreeNode lastnode = null;
    
    // recursive
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (lastnode != null) {
            lastnode.left = null;
            lastnode.right = root;
        }
        lastnode = root;
        TreeNode temp = root.right;
        flatten(root.left);
        flatten(temp);
    }
    
    public static void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }
    
    private static TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        TreeNode tail = root;
        if (left != null) {
            tail.right = left;
            tail = helper(left);
        }
        if (right != null) {
            tail.right = right;
            tail = helper(right);
        }
        return tail;
    }

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
        flatten(a);
        TreeNode cur = a;
        while (cur != null) {
            System.out.print(cur.val + " "); // 1 2 4 5 3
            cur = cur.right;
        }
    }
}
