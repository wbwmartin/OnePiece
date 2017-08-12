import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);
			List<String> item = new ArrayList<String>();
			if (map.containsKey(sorted)) {
				item = map.get(sorted);
			}
			item.add(s);
			map.put(sorted, item);
		}
		for (List<String> list : map.values()) {
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	
    // unit test
    public static void main(String[] args) {
    	String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    	List<List<String>> res = groupAnagrams(strs);
    	System.out.println(res);
    }
}
