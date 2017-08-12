import java.util.HashMap;
import java.util.Map;


public class IsomorphicStrings {
	
	// iterative
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (!map.containsKey(s.charAt(i)) || !map.get(s.charAt(i)).equals(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    // unit test
    public static void main(String[] args) {
    	String a = "paper";
    	String b = "title";
    	System.out.println(isIsomorphic(a, b));
    }
}
