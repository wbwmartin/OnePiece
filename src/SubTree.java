import Utils.TreeNode;

//You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
//
//        Notice
//
//        A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n, the two trees would be identical.
//
//        Example
//        T2 is a subtree of T1 in the following case:
//
//        1                3
//        / \              /
//        T1 = 2   3      T2 =  4
//        /
//        4
//        T2 isn't a subtree of T1 in the following case:
//
//        1               3
//        / \               \
//        T1 = 2   3       T2 =    4
//        /
//        4

public class SubTree {

    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }
        return isEqual(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    private static boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        return T1.val == T2.val && isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        a.left = b;
        a.right = c;
        c.left = d;
        e.left = f;
        System.out.println(isSubtree(a, e)); // true
    }
}
