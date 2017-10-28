import Utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class BTSerialization {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        // write your code here
        String res = buildString(root, "");
        return res.substring(0, res.length() - 1);
    }

    private static String buildString(TreeNode root, String s) {
        if (root == null) {
            return "#;";
        }
        String res = root.val + ";";
        res += buildString(root.left, s) + buildString(root.right, s);
        return res;
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        // write your code here
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(";")));
        return buildTree(nodes);
    }

    private static TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.right = b;
        System.out.println(serialize(a));
        TreeNode d = deserialize(serialize(a));
    }
}
