//Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes
// in the BST.
//
//		According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
// between two nodes v and w as the lowest node in T that has both v and w as descendants
// (where we allow a node to be a descendant of itself).”
//
//		_______6______
//		/              \
//		___2__          ___8__
//		/      \        /      \
//		0      _4       7       9
//		/  \
//		3   5
//		For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is
// LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA
// definition.

import Utils.TreeNode;

public class LowestCommonAncestorBST {

    // recursive
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    // iterative
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while (root.val < p.val || root.val > q.val) {
            if (root.val < p.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
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
        TreeNode res = lowestCommonAncestor(a, d, e);
        TreeNode res2 = lowestCommonAncestor2(a, d, e);
        System.out.println(res.val); // 2
        System.out.println(res2.val); // 2
    }
}
