//Two elements of a binary search tree (BST) are swapped by mistake.
//
//        Recover the tree without changing its structure.
//
//        Note:
//        A solution using O(n) space is pretty straight forward.
//          Could you devise a constant space solution?

import Utils.TreeNode;

public class RecoverBST {

    private static TreeNode FIRST = null;
    private static TreeNode SECOND = null;
    private static TreeNode PREV = new TreeNode(Integer.MIN_VALUE);
    
    // recursion, O(1) space
    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = FIRST.val;
        FIRST.val = SECOND.val;
        SECOND.val = temp;
    }
    
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (FIRST == null && root.val < PREV.val) {
            FIRST = PREV;
        }
        if (FIRST != null && root.val < PREV.val) {
            SECOND = root;
        }
        if (root.val < PREV.val) {

        }
        PREV = root;
        traverse(root.right);
    }
    
    // iterative, Morris
    public static void recoverTree2(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode prev;
        TreeNode tail = null;
        while (root != null) {
            if (root.left == null) {
                if (tail != null && tail.val > root.val) {
                    if (node1 == null) {
                        node1 = tail;
                    }
                    node2 = root;
                }
                tail = root;
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == root) {
                    if (tail.val > root.val) {
                        if (node1 == null) {
                            node1 = tail;
                        }
                        node2 = root;
                    }
                    tail = root;
                    root = root.right;
                    prev.right = null;
                } else {
                    prev.right = root;
                    root = root.left;
                }
            }
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    
	// unit test
	public static void main(String[] args) {
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(1);
		a.right = b;
		b.left = c;
		recoverTree2(a);
		System.out.println(BTInorderTraversal.inorderTraversal(a)); // 1 2 3 4 5 6 7
	}
}
