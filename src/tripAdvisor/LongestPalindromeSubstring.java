package tripAdvisor;


public class LongestPalindromeSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	getString(res, s, i, i);
        	getString(res, s, i, i + 1);
        }
        return res.toString();
    }
    
    private static void getString(StringBuilder res, String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
    	if (right - left - 1 > res.length()) {
    		res.replace(0, res.length(), s.substring(left + 1, right));
    	}
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = "aa";
    	System.out.println(longestPalindrome(s));
    }
}

