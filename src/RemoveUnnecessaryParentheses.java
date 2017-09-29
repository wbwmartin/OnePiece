import java.util.*;

// Given a string containing an expression, return the expression with unnecessary parentheses removed.
//
//        For example:
//
//        f("1*(2+(3*(4+5)))") ===> "1*(2+3*(4+5))"
//        f("2 + (3 / -5)") ===> "2 + 3 / -5"
//        f("x+(y+z)+(t+(v+w))") ===> "x+y+z+t+v+w"

public class RemoveUnnecessaryParentheses {

    public static String removeParentheses(String s) {
        s = "+" + s + "+";
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>(); // the indices of parentheses that need to remove
        Map<Character, Integer> map = new HashMap<>(); // priority of operator
        map.put('+', 1);
        map.put('-', 2);
        map.put('*', 3);
        map.put('/', 4);
        Stack<Integer> leftIndices = new Stack<>(); // indices of left brackets
        Stack<Character> symbols = new Stack<>(); // all symbols and left brackets
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                symbols.push(c);
            } else if (c == '(') {
                leftIndices.push(i);
                symbols.push(c);
            } else if (c == ')') {
                int inside = 4;
                while (symbols.peek() != '(') {
                    inside = Math.min(inside, map.get(symbols.pop()));
                }
                int leftIndex = leftIndices.pop();
                symbols.pop();
                int left = map.getOrDefault(symbols.peek(), 1);
                int right = map.getOrDefault(s.charAt(i + 1), 1);
                if (valid(left, inside, right)) {
                    set.add(leftIndex);
                    set.add(i);
                }
            }
        }
        for (int i = 1; i < s.length() - 1; i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private static boolean valid(int left, int inside, int right) {
        switch (left) {
            case 1:
                return inside <= 2 && right <= 2 || inside > 2;
            case 2:
                return inside > 2;
            case 3:
                return inside > 2;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        try {
            String s1 = "1*(2+3*(4+5))";
            String s2 = "2 + (3 / -5)";
            String s3 = "x+(y+z)+(t+(v+w))";
            String s4 = "(())";
            String s5 = "(456)+((1-2)*3)";
            String s6 = "(1+2))";
            System.out.println(removeParentheses(s1)); // 1*(2+3*(4+5))
            System.out.println(removeParentheses(s2)); // 2 + 3 / -5
            System.out.println(removeParentheses(s3)); // x+y+z+t+v+w
            System.out.println(removeParentheses(s4)); //
            System.out.println(removeParentheses(s5)); // 456+(1-2)*3
            System.out.println(removeParentheses(s6)); // exception
        } catch (Exception e) {
            System.out.println("Wrong input format." + e);
        }

    }
}
