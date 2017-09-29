import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
//		The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (stack.empty() || map.get(c) != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

    // unit test
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";
        System.out.println(isValid(s1)); // true
        System.out.println(isValid(s2)); // false
    }
}
