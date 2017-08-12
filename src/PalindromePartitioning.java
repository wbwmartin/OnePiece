import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {
	
	// recursive
	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> item = new ArrayList<String>();
        helper(res, item, s, 0);
        return res;
    }
    
    private static void helper(List<List<String>> res, List<String> item, String s, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(item));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String prefix = s.substring(pos, i + 1);
            if (!isPalindrome(prefix)) {
                continue;
            }
            item.add(prefix);
            helper(res, item, s, i + 1);
            item.remove(item.size() - 1);
        }
    }
    
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
	// unit test
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> res = partition(s);
		for (List<String> i: res) {
			for (String j: i){
				System.out.print(j + " ");
			}
			System.out.print("\n");
		}
	}

}
