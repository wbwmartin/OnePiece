import java.util.HashSet;
import java.util.Set;


public class LongestSubstringNoRepeatingChar {
	
	// iterative:
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        for (; right < s.length(); right++) {
            char key = s.charAt(right);
            if (set.contains(key)) {
                max = Math.max(max, right - left);
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(key);
            }
        }
        return Math.max(max, right - left);
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = "abcdaef";
    	System.out.println(lengthOfLongestSubstring(s)); // 6
    }
}
