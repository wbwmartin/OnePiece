import java.util.ArrayList;
import java.util.List;

//Given a digit string excluded 01, return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below.

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        for (char c : digits.toCharArray()) {
            if (!Character.isDigit(c) || Integer.valueOf(c) < 2) {
                return res;
            }
        }
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        helper(res, sb, map, digits);
        return res;
    }

    private static void helper(List<String> res, StringBuilder sb, String[] map, String digits) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int key = digits.charAt(sb.length()) - '0' - 2;
        for (char c : map[key].toCharArray()) {
            sb.append(c);
            helper(res, sb, map, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // unit test
    public static void main(String[] args) {
        String num = "23";
        List<String> res = letterCombinations(num);
        for (String i : res) {
            System.out.println(i);
        }
    }

}
