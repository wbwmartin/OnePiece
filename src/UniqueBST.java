import java.util.ArrayList;
import java.util.List;


public class UniqueBST {
	
	// iterative, dynamic programming
    public static int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
    
    // recursive, treenode list
    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    private static List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
    
	// unit test
	public static void main(String[] args) {
		int n = 3;
		System.out.println(numTrees(n));
		List<TreeNode> res = generateTrees(n);
		for (TreeNode i: res) {
			List<Integer> res2 = BTInorderTraversal.inorderTraversal(i);
			for (Integer j: res2) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
