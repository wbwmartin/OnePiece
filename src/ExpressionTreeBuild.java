import java.util.Stack;

//The structure of Expression Tree is a binary tree to evaluate certain expressions.
//        All leaves of the Expression Tree have an number string value. All non-leaves of the Expression Tree have an operator string value.
//
//        Now, given an expression array, build the expression tree of this expression, return the root of this expression tree.
//
//
//        Clarification
//        See wiki:
//        Expression Tree
//
//        Example
//        For the expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]).
//        The expression tree will be like
//
//        [ - ]
//        /          \
//        [ * ]              [ / ]
//        /     \           /         \
//        [ 2 ]  [ 6 ]      [ + ]        [ + ]
//        /    \       /      \
//        [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
//        After building the tree, you just need to return root node [-].

public class ExpressionTreeBuild {

    public static ExpressionTreeNode build(String[] expression) {
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
                    TreeNode left = stack.empty() ? null : stack.peek();
                    if (stack.empty() || left.val > right.val) {
                        right.root.left = cur.root;
                    } else {
                        left.root.right = cur.root;
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
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

    public static class TreeNode {
        public int val;
        public ExpressionTreeNode root;

        public TreeNode(int val, String s) {
            this.val = val;
            this.root = new ExpressionTreeNode(s);
        }
    }

    public static class ExpressionTreeNode {
        public String symbol;
        public ExpressionTreeNode left, right;

        public ExpressionTreeNode(String symbol) {
            this.symbol = symbol;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
        ExpressionTreeNode res = build(expression);
    }
}
