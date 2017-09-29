import java.util.*;

//Given a binary tree, return the vertical order traversal of its nodes' values.
// (ie, from top to bottom, column by column).
//
//        If two nodes are in the same row and column, the order should be from left to right.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given binary tree {3,9,20,#,#,15,7}
//
//        3
//        /\
//        /  \
//        9  20
//        /\
//        /  \
//        15   7
//        Return its vertical order traversal as:
//        [[9],[3,15],[20],[7]]
//
//        Given binary tree {3,9,8,4,0,1,7}
//
//        3
//        /\
//        /  \
//        9   8
//        /\  /\
//        /  \/  \
//        4  01   7
//        Return its vertical order traversal as:
//        [[4],[9],[3,0,1],[8],[7]]

public class BTVerticalOrderTraversal {

    // iterative, BFS level order traversal
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(0);
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            int index = q2.poll();
            if (map.containsKey(index)) {
                map.get(index).add(node.val);
            } else {
                map.put(index, new ArrayList<>(Arrays.asList(node.val)));
            }
            if (node.left != null) {
                q1.offer(node.left);
                q2.offer(index - 1);
            }
            if (node.right != null) {
                q1.offer(node.right);
                q2.offer(index + 1);
            }
        }
        for (int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        List<List<Integer>> res = verticalOrder(a);
        for (List<Integer> list : res) {
            System.out.println(list); // [[4] [2] [1, 5] [3]]
        }
    }

}

