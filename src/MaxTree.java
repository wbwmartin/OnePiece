import java.util.List;
import java.util.Stack;

//Given an integer array with no duplicates. A max tree building on this array is defined as follow:
//
//        The root is the maximum number in the array
//        The left subtree and right subtree are the max trees of the subarray divided by the root number.
//        Construct the max tree by the given array.
//
//        Example
//        Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
//
//        6
//        / \
//        5   3
//        /   / \
//        2   0   1
//        Challenge
//        O(n) time and memory.

public class MaxTree {

    public static TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i <= A.length; i++) {
            TreeNode cur = new TreeNode(i < A.length ? A[i] : Integer.MAX_VALUE);
            while (!stack.empty()) {
                if (stack.peek().val > cur.val) {
                    break;
                } else {
                    TreeNode top = stack.pop();
                    if (stack.empty() || stack.peek().val > cur.val) {
                        cur.left = top;
                    } else {
                        stack.peek().right = top;
                    }
                }
            }
            stack.push(cur);
        }
        return stack.pop().left;
    }

    // unit test
    public static void main(String[] args) {
        int[] A = {2, 5, 6, 0, 3, 1};
        TreeNode node = maxTree(A);
        List<List<Integer>> res = BTLevelOrderTraversal.levelOrder(node);
        for (List<Integer> i : res) {
            for (Integer j : i) {
                System.out.print(j + " "); // 6 | 5 3 | 2 0 1
            }
            System.out.println();
        }
    }
}
