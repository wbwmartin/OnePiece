import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	// iterative
	public static String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0) {
			return "";
		}
		int start = 0;
		int end = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int count = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		for (; right < s.length(); right++) {
			char c = s.charAt(right);
			if (!map.containsKey(c)) {
				continue;
			}
			map.put(c, map.get(c) - 1);
			if (map.get(c) >= 0) {
				count++;
			}
			while (count == t.length()) {
				if (right - left < end - start) {
					start = left;
					end = right;
				}
				if (map.containsKey(s.charAt(left))) {
					map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
					if (map.get(s.charAt(left)) > 0) {
						count--;
					}
				}
				left++;
			}
		}
		if (end - start > s.length()) {
			return "";
		} else {
			return s.substring(start, end + 1);
		}
	}
	
    // unit test
    public static void main(String[] args) {
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	System.out.println(minWindow(s, t));
    }
}
