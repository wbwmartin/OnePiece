import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//        Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//        Some examples:
//        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

public class EvaluateReversePolish {

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (!"+-*/".contains(s)) {
                stack.push(Integer.valueOf(s));
                continue;
            }
            int n2 = stack.pop();
            int n1 = stack.pop();
            switch (s) {
                case "+":
                    stack.push(n1 + n2);
                    break;
                case "-":
                    stack.push(n1 - n2);
                    break;
                case "*":
                    stack.push(n1 * n2);
                    break;
                case "/":
                    stack.push(n1 / n2);
                    break;
                default:
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] s1 = {"2", "1", "+", "3", "*"};
        String[] s2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(s1)); // 9
        System.out.println(evalRPN(s2)); // 6
    }
}
