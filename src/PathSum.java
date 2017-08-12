import java.util.ArrayList;
import java.util.List;

public class PathSum {
	
	// recursive
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    // recursive, backtracking
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        List<Integer> item = new ArrayList<Integer>();
        helper(res, item, root, sum);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> item, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            List<Integer> temp = new ArrayList<Integer>(item);
            temp.add(root.val);
            res.add(temp);
            return;
        }
        item.add(root.val);   
        helper(res, item, root.left, sum);
        helper(res, item, root.right, sum);
        item.remove(item.size() - 1);
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
		System.out.println(hasPathSum(a, 7));
		List<List<Integer>> res = pathSum(a, 7);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
	}
	
}
