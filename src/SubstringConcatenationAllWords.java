import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubstringConcatenationAllWords {

	// iterative
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        int m = s.length();
        int n = words.length;
        int l = words[0].length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i <= m - n * l; i++) {
            Map<String, Integer> temp = new HashMap<String, Integer>();
            int j;
            for (j = 0; j < n; j++) {
                int k = i + j * l;
                String stub = s.substring(k, k + l);
                if (!map.containsKey(stub)) {
                    break;
                }
                if (temp.containsKey(stub)) {
                    temp.put(stub, temp.get(stub) + 1);
                } else {
                    temp.put(stub, 1);
                }
                if (temp.get(stub) > map.get(stub)) {
                    break;
                }
            }
            if (j == n) {
                res.add(i);
            }
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	String s = "barfoothefoobarman";
    	String[] words = {"foo", "bar"};
    	List<Integer> res = new ArrayList<Integer>(findSubstring(s, words));
    	System.out.println(res);
    }
}
