import java.util.*;

//Given an expression string array, return the final result of this expression
//
//        Notice
//
//        The expression contains only integer, +, -, *, /, (, ).
//
//        Example
//        For the expression 2*6-(23+7)/(1+2),
//        input is
//
//        [
//        "2", "*", "6", "-", "(",
//        "23", "+", "7", ")", "/",
//        (", "1", "+", "2", ")"
//        ],
//        return 2

public class ExpressionEvaluation {

    public static int evaluateExpression(String[] expression) {
        Stack<Integer> integers = new Stack<>();
        Stack<String> ops = new Stack<>();
        int i = 0;
        while (i < expression.length) {
            String cur = expression[i];
            if ("+-*/()".contains(cur)) { // current string is an op
                if (cur.equals("(")) {
                    ops.push(cur);
                } else if (cur.equals(")")) {
                    while (!ops.empty() && !ops.peek().equals("(")) {
                        integers.push(calc(integers.pop(), integers.pop(), ops.pop()));
                    }
                    ops.pop();
                } else { // +,-,*,/
                    while (!ops.empty() && precede(cur, ops.peek())) {
                        integers.push(calc(integers.pop(), integers.pop(), ops.pop()));
                    }
                    ops.push(cur);
                }
            } else {
                integers.push(Integer.parseInt(cur)); // current String is an integer, push to integer stack
            }
            i++;
        }

        while (!ops.isEmpty()) {
            integers.push(calc(integers.pop(), integers.pop(), ops.pop()));
        }
        return integers.empty() ? 0 : integers.pop();
    }

    public static int calc(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return b - a;
            case "*":
                return a * b;
            default:
                return b / a;
        }
    }

    public static boolean precede(String a, String b) {
        if (b.equals("*") || b.equals("/")) {
            return true;
        }
        if (b.equals("+") || b.equals("-")) {
            return !a.equals("*") && !a.equals("/");
        }
        return false;
    }

    public static void main(String[] args) {
        String[] expression = {"2", "*", "6", "-", "(",
                "23", "+", "7", ")", "/",
                "(", "1", "+", "2", ")"};
        System.out.println(evaluateExpression(expression)); // 2
    }
}
