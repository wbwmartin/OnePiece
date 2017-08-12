import java.util.Stack;

// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string contains only non-negative integers, +, -, *, /
// operators and empty spaces . The integer division should truncate toward zero.
//
//        You may assume that the given expression is always valid.
//
//        Some examples:
//        "3+2*2" = 7
//        " 3/2 " = 1
//        " 3+5 / 2 " = 5
//        Note: Do not use the eval built-in library function.

public class BasicCalculatorII {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                } else if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                }
                sign = s.charAt(i);
                number = 0;
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    // unit test
    public static void main(String[] args) {
        String s1 = "3+2* 2";
        String s2 = " 3/2 ";
        String s3 = " 3+5 / 2 ";
        System.out.println(calculate(s1)); // 7
        System.out.println(calculate(s2)); // 1
        System.out.println(calculate(s3)); // 5
    }
}
