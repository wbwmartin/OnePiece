import java.util.Stack;


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
    		} else if (c == '+' || c == '('){
    			stack.push(stack.peek());
    		} else if (c == '-') {
    			stack.push(-1 * stack.peek());
    		} else if (c == ')') {
    			stack.pop();
    		}    		
    	}
        return res;
    }
	
    // unit test
    public static void main(String[] args) {
    	String s = " 2-1 + 2 "; 
    	String s2 = "(1+(4+5+2)-3)+(6+8)";
    	System.out.println(calculate(s)); // 3
    	System.out.println(calculate(s2)); // 23
    }
}
