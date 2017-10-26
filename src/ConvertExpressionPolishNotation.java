import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Given an expression string array, return the Polish notation of this expression. (remove the parentheses)
//
//
//        Clarification
//        Definition of Polish Notation:
//
//        http://en.wikipedia.org/wiki/Polish_notation
//        http://baike.baidu.com/view/7857952.htm
//        Example
//        For the expression [(5 − 6) * 7] (which represented by ["(", "5", "−", "6", ")", "*", "7"]), the corresponding polish notation is [* - 5 6 7] (which the return value should be ["*", "−", "5", "6", "7"]).

public class ConvertExpressionPolishNotation {

    public static List<String> convertToPN(String[] expression) {
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
        res.add(root.s);
        traverse(root.left, res);
        traverse(root.right, res);
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
        String[] expression = {"(", "5", "−", "6", ")", "*", "7"};
        System.out.println(convertToPN(expression)); // "*", "−", "5", "6", "7"
    }
}
