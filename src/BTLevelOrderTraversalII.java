import Utils.TreeNode;

import java.util.*;

public class BTLevelOrderTraversalII {

    // iterative, bfs, queue, bottom-up
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> item = new ArrayList<>();
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
            stack.push(item);
        }
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode a = TreeNode.createBT();
        List<List<Integer>> res = levelOrder(a);
        for (List<Integer> list : res) {
            System.out.println(list); // 4 5 | 2 3 | 1
        }
    }
}
