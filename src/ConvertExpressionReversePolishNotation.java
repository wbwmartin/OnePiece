import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given an expression string array, return the Reverse Polish notation of this expression. (remove the parentheses)
//
//
//        Example
//        For the expression [3 - 4 + 5] (which denote by ["3", "-", "4", "+", "5"]), return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"])

public class ConvertExpressionReversePolishNotation {

    public static List<String> convertToRPN(String[] expression) {
        Stack<TreeNode> stack = new Stack<>();
        int val = 0;
        int base = 0;
        for (int i = 0; i <= expression.length; i++) {
            if (i < expression.length) {
                if ("(".equals(expression[i])) {
                    base += 10;
                    continue;
                }
                if (")".equals(expression[i])) {
                    base -= 10;
                    continue;
                }
                val = getVal(expression[i], base);
            }
            TreeNode right = i == expression.length
                    ? new TreeNode(Integer.MIN_VALUE, "")
                    : new TreeNode(val, expression[i]);
            while (!stack.empty()) {
                if (right.val <= stack.peek().val) {
                    TreeNode cur = stack.pop();
                    if (stack.empty()) {
                        right.left = cur;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val < right.val) {
                            right.left = cur;
                        } else {
                            left.right = cur;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        List<String> res = new ArrayList<>();
        traverse(stack.peek().left, res);
        return res;
    }

    private static int getVal(String s, int base) {
        if ("+".equals(s) || "-".equals(s)) {
            return 1 + base;
        }
        if ("*".equals(s) || "/".equals(s)) {
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    }

    private static void traverse(TreeNode root, List<String> res) {
        if (root == null) {
            return;
        }
        traverse(root.left, res);
        traverse(root.right, res);
        res.add(root.s);
    }

    public static class TreeNode {
        public int val;
        public String s;
        public TreeNode left = null;
        public TreeNode right = null;

        public TreeNode(int val, String s) {
            this.val = val;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        String[] expression = {"3", "-", "4", "+", "5"};
        System.out.println(convertToRPN(expression)); // 3 4 - 5 +
    }
}
