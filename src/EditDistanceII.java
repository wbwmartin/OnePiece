//Given two strings S and T, determine if they are both one edit distance apart.
//
//        Example
//        Given s = "aDb", t = "adb"
//        return true

public class EditDistanceII {

    public static boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if (s == null || t == null || Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                    if (s.length() == t.length()) {
                        i++;
                        j++;
                    } else if (s.length() < t.length()) {
                        j++;
                    } else {
                        i++;
                    }
                }
            }
        }
        return flag || !flag && s.length() != t.length();
    }

    // unit test
    public static void main(String[] args) {
        String a = "abc";
        String b = "abcd";
        String c = "abcde";
        System.out.println(isOneEditDistance(a, a)); // false
        System.out.println(isOneEditDistance(a, b)); // true
        System.out.println(isOneEditDistance(a, c)); // false
    }
}
