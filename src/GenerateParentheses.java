import java.util.ArrayList;
import java.util.List;

// Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//        For example, given n = 3, a solution set is:
//
//        [
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"
//        ]

public class GenerateParentheses {

    // recursive
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        String item = "";
        helper(res, item, n, n);
        return res;
    }

    private static void helper(List<String> res, String item, int left, int right) {
        if (left > right || left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(item);
            return;
        }
        helper(res, item + "(", left - 1, right);
        helper(res, item + ")", left, right - 1);
    }

    // unit test
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res); // [((())), (()()), (())(), ()(()), ()()()]
    }
}
