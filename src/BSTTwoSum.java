import java.util.ArrayList;
import java.util.List;

//Given a Binary Search Tree and a target number,
// return all pairs that two elements in the BST such that
// their sum is equal to the given target.
//
//        Example 1:
//        Input:
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Target = 9
//
//        Output: [[2,7], [3,6], [4,5]]

public class BSTTwoSum {

    public static List<List<Integer>> twoSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode tail = null;
        TreeNode head = null;
        TreeNode prev = null;
        while (root != null) {
            if (root.left == null) {
                if (head == null) {
                    head = root;
                }
                root.left = tail;
                if (tail != null) {
                    tail.right = root;
                }
                tail = root;
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    tail.right = root;
                    root.left = tail;
                    tail = root;
                    root = root.right;
                }
            }
        }
        while (head.val < tail.val) {
            int sum = head.val + tail.val;
            if (sum == target) {
                List<Integer> item = new ArrayList<>();
                item.add(head.val);
                item.add(tail.val);
                res.add(item);
                head = head.right;
                tail = tail.left;
            } else if (sum < target) {
                head = head.right;
            } else {
                tail = tail.left;
            }
        }
        return res;
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
        System.out.println(twoSum(a, 6)); // 1 5, 2 4

		/*TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(5);
		TreeNode g = new TreeNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;	
		c.left = f;
		c.right = g;
		System.out.println(twoSum(a, 8)); // 1 7, 2 6, 3 5*/
    }
}
