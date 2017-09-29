import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
//        For example, given:
//        s: "barfoothefoobarman"
//        words: ["foo", "bar"]
//
//        You should return the indices: [0,9].
//        (order does not matter).

public class SubstringConcatenationAllWords {

    // iterative
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0 || words[0].length() == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
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
            Map<String, Integer> temp = new HashMap<>();
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
        List<Integer> res = new ArrayList<>(findSubstring(s, words)); // 0 9
        System.out.println(res);
    }
}
