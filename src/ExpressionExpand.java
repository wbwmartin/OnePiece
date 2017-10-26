import java.util.Stack;

//Given an expression s includes numbers, letters and brackets. Number represents the number of repetitions inside the brackets(can be a string or another expression)．Please expand expression to be a string.
//
//        Example
//        s = abc3[a] return abcaaa
//        s = 3[abc] return abcabcabc
//        s = 4[ac]dy, return acacacacdy
//        s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz
//
//        Challenge
//        Can you do it without recursion?

public class ExpressionExpand {

    public static String expressionExpand(String s) {
        Stack<Object> stack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                stack.push(Integer.valueOf(num));
                num = 0;
            } else if (c == ']') {
                String newStr = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int i = 0; i < count; i++) {
                    stack.push(newStr);
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }
        return popStack(stack);
    }

    private static String popStack(Stack<Object> stack) {
        // pop stack until get a number or empty
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3[2[ad]3[pf]]xyz";
        System.out.println(expressionExpand(s)); // adadpfpfpfadadpfpfpfadadpfpfpfxyz
    }
}
