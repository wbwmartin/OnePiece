import Utils.TreeNode;

//Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//
//        Note: If the given node has no in-order successor in the tree, return null.

public class InorderSuccessorBST {

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBST();
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(6);
        System.out.println(inorderSuccessor(root, p1).toString()); // 4
        System.out.println(inorderSuccessor(root, p2).toString()); // 7
    }
}
