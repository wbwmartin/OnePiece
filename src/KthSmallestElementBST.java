import java.util.Stack;

//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//        Note:
//        You may assume k is always valid, 1 ? k ? BST's total elements.
//
//        Follow up:
//        What if the BST is modified (insert/delete operations) often and you need to find the
//        kth smallest frequently? How would you optimize the kthSmallest routine?


public class KthSmallestElementBST {

    // Inorder traversal, O(n)
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            if (root.left != null) {
                root = root.left;
                stack.push(root);
            } else {
                TreeNode temp = stack.pop();
                count++;
                if (count == k) {
                    return temp.val;
                }
                if (temp.right != null) {
                    root = temp.right;
                    stack.push(root);
                }
            }
        }
        return 0;
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
        int res = kthSmallest(a, 3);
        System.out.println(res); // 3
    }
}
