import Utils.TreeNode;

import java.util.List;

//Invert a binary tree.
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        to
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1

public class InvertBT {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        TreeNode node = invertTree(a);
        List<List<Integer>> res = BTLevelOrderTraversal.levelOrder(node);
        for (List<Integer> list : res) {
            System.out.println(list); // 1 | 3 2 | 5 4
        }
    }
}
