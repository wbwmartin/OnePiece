import java.util.Stack;

//Implement a basic calculator to evaluate a simple expression string.
//
//        The expression string may contain open ( and closing parentheses ),
//        the plus + or minus sign -, non-negative integers and empty spaces .
//
//        You may assume that the given expression is always valid.
//
//        Some examples:
//        "1 + 1" = 2
//        " 2-1 + 2 " = 3
//        "(1+(4+5+2)-3)+(6+8)" = 23
//        Note: Do not use the eval built-in library function.

public class BasicCalculator {

    // iterative, stack
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = 10 * num + (s.charAt(j) - '0');
                    j++;
                }
                res += stack.pop() * num;
                i = j - 1;
            } else if (c == '+' || c == '(') {
                stack.push(stack.peek());
            } else if (c == '-') {
                stack.push(-1 * stack.peek());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return res;
    }

    // better implementation
    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = " 2-1 + 2 ";
        String s2 = "(1+(4+5+2)-3)+(6+8)";
        String s3 = " 23 - (10 -5)   ";
        System.out.println(calculate(s)); // 3
        System.out.println(calculate(s2)); // 23
        System.out.println(calculate(s3)); // 18

        System.out.println(calculate2(s)); // 3
        System.out.println(calculate2(s2)); // 23
        System.out.println(calculate2(s3)); // 18
    }

}
