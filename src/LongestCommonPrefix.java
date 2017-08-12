
public class LongestCommonPrefix {
	
	// iterative
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }
    
    // unit test
    public static void main(String[] args) {
    	String[] strs = {"abc", "abcd", "abcde", "ab"};
    	System.out.println(longestCommonPrefix(strs)); // "ab"
    }
}
