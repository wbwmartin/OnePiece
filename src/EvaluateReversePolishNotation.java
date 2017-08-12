import java.util.Stack;


public class EvaluateReversePolishNotation {

	// stack
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String operations = "+-*/";
        for (String t: tokens) {
            if (!operations.contains(t)) {
                stack.push(Integer.valueOf(t));
                continue;
            }
            int a = stack.pop();
            int b = stack.pop();
            if (t.equals("+")) {
                stack.push(b + a);
            } else if (t.equals("-")) {
                stack.push(b - a);
            } else if (t.equals("*")) {
                stack.push(b * a);
            } else {
                stack.push(b / a);
            }
        }
        return stack.peek();
    }
    
    // unit test
    public static void main(String[] args) {
    	String[] tokens = {"2", "1", "+", "3", "*"};
    	System.out.println(evalRPN(tokens)); // 9
    }
}
