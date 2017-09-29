//Given a binary search tree and a new tree node, insert the node into the tree.
// You should keep the tree still be a valid binary search tree.
//
//        Notice
//
//        You can assume there is no duplicate values in this tree + node.

public class InsertNodeBST {

    public static TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            return node;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            pre = cur;
            if (cur.val < node.val) {
                cur = cur.right;
            } else if (cur.val > node.val) {
                cur = cur.left;
            } else {
                return root;
            }
        }
        if (pre != null) {
            if (pre.val > node.val) {
                pre.left = node;
            } else {
                pre.right = node;
            }
        }
        return root;
    }

    // unit test
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
        TreeNode n = new TreeNode(6);
        insertNode(a, n);
        System.out.println(BTInorderTraversal.inorderTraversal(a)); // 1 2 3 4 5 6
    }
}
