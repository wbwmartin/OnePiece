import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree
//
//        struct TreeLinkNode {
//        TreeLinkNode *left;
//        TreeLinkNode *right;
//        TreeLinkNode *next;
//        }
//        Populate each next pointer to point to its next right node.
//          If there is no next right node, the next pointer should be set to NULL.
//
//        Initially, all next pointers are set to NULL.
//
//        Note:
//
//        You may only use constant extra space.
//        You may assume that it is a perfect binary tree (ie, all leaves are at the same
//          level, and every parent has two children).
//        For example,
//        Given the following perfect binary tree,
//        1
//        /  \
//        2    3
//        / \  / \
//        4  5  6  7
//        After calling your function, the tree should look like:
//        1 -> NULL
//        /  \
//        2 -> 3 -> NULL
//        / \  / \
//        4->5->6->7 -> NULL

public class PopulateNextRightPointer {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode temp = queue.poll();
                if (i == size - 1) {
                    temp.next = null;
                } else {
                    temp.next = queue.peek();
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
    }

    // unit test
    public static void main(String[] args) {
        TreeLinkNode a = new TreeLinkNode(1);
        TreeLinkNode b = new TreeLinkNode(2);
        TreeLinkNode c = new TreeLinkNode(3);
        TreeLinkNode d = new TreeLinkNode(4);
        TreeLinkNode e = new TreeLinkNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        connect(a);
    }
}
