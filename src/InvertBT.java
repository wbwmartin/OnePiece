import java.util.List;


public class InvertBT {
	
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
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
		TreeNode node = invertTree(a);
		List<List<Integer>> res = BTLevelOrderTraversal.levelOrder(node);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
