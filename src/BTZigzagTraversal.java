import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, return the zigzag level order traversal of its nodes' values.
// (ie, from left to right, then right to left for the next level and alternate between).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as:
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

public class BTZigzagTraversal {

    // iterative, bfs, quue
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        int sign = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                item.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            if (sign == 0) {
                reverseList(item);
            }
            sign = 1 - sign;
            res.add(item);
        }
        return res;
    }

    private static void reverseList(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(i, list.remove(size - 1));
        }
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        List<List<Integer>> res = zigzagLevelOrder(a);
        for (List<Integer> list : res) {
            System.out.println(list); // 1 | 3 2 | 4 5
        }
    }
}

