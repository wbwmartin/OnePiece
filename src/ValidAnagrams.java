import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, write a function to determine if t is an anagram of s.
//
//        For example,
//        s = "anagram", t = "nagaram", return true.
//        s = "rat", t = "car", return false.
//
//        Note:
//        You may assume the string contains only lowercase alphabets.
//
//        Follow up:
//        What if the inputs contain unicode characters? How would you adapt your solution to such case?

public class ValidAnagrams {

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram2(s, t)); // true
    }
}
