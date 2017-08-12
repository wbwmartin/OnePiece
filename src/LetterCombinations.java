import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCombinations {
	
	// recursive
	public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, char[]> hp = new HashMap<Character, char[]>();
        hp.put('0', new char[]{});
        hp.put('1', new char[]{});
        hp.put('2', new char[]{'a', 'b', 'c'});
        hp.put('3', new char[]{'d', 'e', 'f'});
        hp.put('4', new char[]{'g', 'h', 'i'});
        hp.put('5', new char[]{'j', 'k', 'l'});
        hp.put('6', new char[]{'m', 'n', 'o'});
        hp.put('7', new char[]{'p', 'q', 'r', 's'});
        hp.put('8', new char[]{'t', 'u', 'v'});
        hp.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        StringBuilder sb = new StringBuilder();
        helper(res, sb, digits, hp);
        return res;
    }
    
    private static void helper(List<String> res, StringBuilder sb, String digits, Map<Character, char[]> hp) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        for (char c: hp.get(digits.charAt(sb.length()))) {
            sb.append(c);
            helper(res, sb, digits, hp);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // unit test
	public static void main(String[] args) {
		String num = "23";
		List<String> res = letterCombinations(num);
		for (String i: res) {
			System.out.println(i);
		}	
	}

}
