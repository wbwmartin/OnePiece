import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.
//
//        For example:
//        Given the following binary tree,
//        1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---
//        You should return [1, 3, 4].

public class BTRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp = new TreeNode(0);
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(temp.val);
        }
        return res;
    }

    // recursion
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        System.out.println(rightSideView(a)); // 1 3 5
    }
}
