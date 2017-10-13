import java.util.HashSet;
import java.util.Set;

//Given a string, find the length of the longest substring without repeating characters.
//
//        Examples:
//
//        Given "abcabcbb", the answer is "abc", which the length is 3.
//
//        Given "bbbbb", the answer is "b", with the length of 1.
//
//        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must
//          be a substring, "pwke" is a subsequence and not a substring.

public class LongestSubstringNoRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0, res = 0;
        Set<Character> set = new HashSet<>();
        for (; i < s.length(); i++) {
            while (j < s.length()) {
                if (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                } else {
                    set.add(s.charAt(j));
                    j++;
                    res = Math.max(res, j - i);
                }
            }
        }
        return Math.max(res, j - i);
    }

    // unit test
    public static void main(String[] args) {
        String s = "abcdaef";
        System.out.println(lengthOfLongestSubstring(s)); // 6
    }
}
