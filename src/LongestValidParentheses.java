import java.util.Stack;

//Given a string containing just the characters '(' and ')', find the length of the longest valid
// (well-formed) parentheses substring.
//
//        For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
//        Another example is ")()())", where the longest valid parentheses substring is "()()",
//          which has length = 4.

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int start = -1;
        int local;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.empty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        local = i - start;
                    } else {
                        local = i - stack.peek();
                    }
                    max = Math.max(max, local);
                }
            }
        }
        return max;
    }

    // unit test
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s)); // 4
    }
}
