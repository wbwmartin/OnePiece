import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest substring T that contains at most k distinct characters.
//
//
//        Example
//        For example, Given s = "eceba", k = 3,
//
//        T is "eceb" which its length is 4.
//
//        Challenge
//        O(n), n is the size of the string s.

public class LongestSubstringMostKDistanceCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, res = 0;
        if (k == 0) {
            return 0;
        }
        for (; i < s.length(); i++) {
            while (j < s.length()) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    j++;
                } else if (map.size() < k) {
                    map.put(c, 1);
                    j++;
                } else {
                    break;
                }
            }
            res = Math.max(res, j - i);
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int k = 3;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k)); // 4
    }
}
