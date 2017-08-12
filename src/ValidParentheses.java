import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	// iterative, stack
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char item = s.charAt(i);
			if (map.containsKey(item)) {
				stack.push(item);
				continue;
			}
			if (!stack.empty() && map.get(stack.pop()).equals(item)) {
				continue;
			}
			return false;
		}
		return stack.empty();
	}

	// method 2
	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (Character c : s.toCharArray()) {
			if ("([{".contains(String.valueOf(c))) {
				stack.push(c);
			} else if (stack.empty() || !isMatched(stack.pop(), c)) {
				return false;
			}
		}
		return stack.empty();
	}

	private static boolean isMatched(Character c1, Character c2) {
		return c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{'
				&& c2 == '}';
	}

	// unit test
	public static void main(String[] args) {
		String s1 = "()[]{}";
		String s2 = "([)]";
		System.out.println(isValid(s1)); // true
		System.out.println(isValid2(s2)); // false
	}
}
