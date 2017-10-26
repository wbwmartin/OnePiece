//Implement regular expression matching with support for '.' and '*'.
//
//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//
//        The matching should cover the entire input string (not partial).
//
//        The function prototype should be:
//        bool isMatch(string s, string p)
//
//        Example
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true

public class RegularExpressionMatching {

    //http://www.cnblogs.com/grandyang/p/4461713.html
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && dp[i - 1][j] && check(s.charAt(i - 1), p.charAt(j - 2)));
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && check(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private static boolean check(char x, char y) {
        return y == '.' || x == y;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "aa")); // true
        System.out.println(isMatch("aaa", "aa")); // false
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("aa", ".*")); // true
        System.out.println(isMatch("ab", ".*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // true
    }
}
