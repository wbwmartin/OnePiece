import java.util.*;

//Given an array of strings, group anagrams together.
//
//        For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
//        Return:
//
//        [
//        ["ate", "eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]

public class Anagrams {

    // iterative
    public static List<String> anagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        List<String> res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                if (map.get(key).size() == 1) {
                    res.add(map.get(key).get(0));
                }
                map.get(key).add(s);
                res.add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            }
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        String[] strs = {"abc", "cba", "kk", "cd", "dc", "bca"};
        System.out.println(anagrams(strs));
    }
}
