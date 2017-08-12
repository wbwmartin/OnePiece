
public class FlattenBTLinkedList {

    static TreeNode lastnode = null;
    
    // revursive
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (lastnode != null) {
            lastnode.left = null;
            lastnode.right = root;
        }
        lastnode = root;
        TreeNode temp = root.right;
        flatten(root.left);
        flatten(temp);
    }
    
    public static void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }
    
    private static TreeNode helper(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        TreeNode tail = root;
        if (left != null) {
            tail.right = left;
            tail = helper(left);
        }
        if (right != null) {
            tail.right = right;
            tail = helper(right);
        }
        return tail;
    }
    
    // unit test
    public static void main(String[] args) {
    	
    }
}
