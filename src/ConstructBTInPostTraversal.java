import Utils.TreeNode;

import java.util.List;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//        Note:
//        You may assume that duplicates do not exist in the tree.

public class ConstructBTInPostTraversal {

    // recursive
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode helper(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        int pos = findPosition(inorder, instart, inend, postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = helper(inorder, instart, pos - 1, postorder, poststart, poststart + pos - instart - 1);
        root.right = helper(inorder, pos + 1, inend, postorder, poststart + pos - instart, postend - 1);
        return root;
    }

    private static int findPosition(int[] inorder, int instart, int inend, int val) {
        int i;
        for (i = instart; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = buildTree(inorder, postorder);
        List<List<Integer>> res = BTLevelOrderTraversal.levelOrder(root); // 1 | 2 3 | 4 5 6 7
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
