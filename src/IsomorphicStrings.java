//Given two strings s and t, determine if they are isomorphic.
//
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order
// of characters. No two characters may map to the same character but a character may map to itself.
//
//        For example,
//        Given "egg", "add", return true.
//
//        Given "foo", "bar", return false.
//
//        Given "paper", "title", return true.
//
//        Note:
//        You may assume both s and t have the same length.

public class IsomorphicStrings {

    // iterative
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int s1 = (int) s.charAt(i);
            int t1 = (int) t.charAt(i);
            if (hash1[s1] == 0 && hash2[t1] == 0) {
                hash1[s1] = t1;
                hash2[t1] = 1;
            } else if (hash1[s1] != t1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
    }
}
