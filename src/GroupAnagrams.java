import java.util.*;

// Given an array of strings, group anagrams together.
//
//        For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Return:
//
//        [
//        ["ate", "eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        Note: All inputs will be in lower-case.

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> item = new ArrayList<>();
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

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs); // [[ate, eat, tea], [bat], [nat, tan]]
        System.out.println(res);
    }
}
