//Given a root of Binary Search Tree with unique value for each node. Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still a binary search tree after removal.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given binary search tree:
//
//        5
//        / \
//        3   6
//        / \
//        2   4
//        Remove 3, you can either return:
//
//        5
//        / \
//        2   6
//        \
//        4
//        or
//
//        5
//        / \
//        4   6
//        /
//        2

public class RemoveNodeBST {

    // recursive
    public static TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        if (value < root.val) {
            root.left = removeNode(root.left, value);
        } else if (value > root.val) {
            root.right = removeNode(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode temp = root;
            root = findMin(root.right);
            root.right = deleteMin(temp.right);
            root.left = temp.left;
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    // iterative
    public static TreeNode removeNode2(TreeNode root, int value) {
        // write your code here
        TreeNode head = new TreeNode(Integer.MAX_VALUE);
        TreeNode res = head;
        head.left = root;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < value) {
                head = cur;
                cur = cur.right;
            } else if (cur.val > value) {
                head = cur;
                cur = cur.left;
            } else {
                if (cur.val < head.val) {
                    if (cur.right == null) {
                        head.left = cur.left;
                    } else {
                        TreeNode pre = cur;
                        cur = cur.right;
                        while (cur.left != null) {
                            pre = cur;
                            cur = cur.left;
                        }
                        head.left.val = cur.val;
                        if (pre.right == cur) {
                            pre.right = cur.right;
                        } else {
                            pre.left = cur.right;
                        }
                    }
                } else {
                    if (cur.left == null) {
                        head.right = cur.right;
                    } else {
                        TreeNode pre = cur;
                        cur = cur.left;
                        while (cur.right != null) {
                            pre = cur;
                            cur = cur.right;
                        }
                        head.right.val = cur.val;
                        if (pre.left == cur) {
                            pre.left = cur.left;
                        } else {
                            pre.right = cur.left;
                        }
                    }
                }
            }
        }
        return res.left;
    }

    // unit test
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        TreeNode res = removeNode(a, 3);
        TreeNode res2 = removeNode2(a, 3);
        System.out.println(BTInorderTraversal.inorderTraversal(res)); // 2 4 5 6
        System.out.println(BTInorderTraversal.inorderTraversal(res2)); // 2 4 5 6
    }
}
