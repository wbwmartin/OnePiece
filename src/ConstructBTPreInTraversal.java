import java.util.List;


public class ConstructBTPreInTraversal {
	
	// recursive
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private static TreeNode helper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int pos = findPosition(inorder, instart, inend, preorder[prestart]);
        root.left = helper(preorder, prestart + 1, prestart + pos - instart, inorder, instart, pos - 1);
        root.right = helper(preorder, prestart + pos - instart + 1, preend, inorder, pos + 1, inend);
        return root;
    }
    
    private static int findPosition(int[] inorder, int instart, int inend, int val) {
        int i;
        for (i = instart; i <= inend; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
    
	// unit test
	public static void main(String[] args) {
		int[] preorder = {1, 2, 4, 5, 3, 6, 7};
		int[] inorder = {4, 2, 5, 1, 6, 3, 7};
		TreeNode root = buildTree(preorder, inorder);
		List<List<Integer>> res = BTLevelOrderTraversal.levelOrder(root);
		for (List<Integer> i: res) {
			for (Integer j: i){
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
}
