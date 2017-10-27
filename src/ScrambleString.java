// Given a string s1, we may repdpent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//        Below is one possible repdpentation of s1 = "great":
//
//        great
//        /    \
//        gr    eat
//        / \    /  \
//        g   r  e   at
//        / \
//        a   t
//        To scramble the string, we may choose any non-leaf node and swap its two children.
//
//        For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
//
//        rgeat
//        /    \
//        rg    eat
//        / \    /  \
//        r   g  e   at
//        / \
//        a   t
//        We say that "rgeat" is a scrambled string of "great".
//
//        Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
//
//        rgtae
//        /    \
//        rg    tae
//        / \    /  \
//        r   g  ta  e
//        / \
//        t   a
//        We say that "rgtae" is a scrambled string of "great".
//
//        Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
//
//        Challenge
//        O(n3) time

public class ScrambleString {

//    State:
//            • dp[x][y][k] means s1 start from x, s2 start from y, len = k, if the substrs is scramble
//• Function:
//            • for 1 <= i <= k
//• s11 = s1.substring(0, i); s12 = s1.substring(i, s1.length());
//• s21 = s2.substring(0, i); s22 = s2.substring(i, s2.length());
//• s23 = s2.substring(0, s2.length() - i); s24 = s2.substring(s2.length() - i, s2.length());
//  check s11s21 && s12s22 || s11s23 && s12s24

//• for i = x -> x+k
//• dp[x][y][k] |= (dp[x][y][i] && dp[x+i][y+i][k-i]) || dp[x][y+k-i][i] && dp[x+i][y][k-i])
//            • Intialize:
//            • dp[i][j][1] = s1[i]==s[j].
//            • Answer:
//            • dp[0][0][len]

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i <= s1.length() - len; i++) {
                for (int j = 0; j <= s2.length() - len; j++) {
                    for (int k = 1; k < len; k++) {
                        dp[i][j][len] |= (dp[i][j][k] && dp[i + k][j + k][len - k]) || (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }

    // unit test
    public static void main(String[] args) {
        System.out.println(isScramble("a", "b")); // false
        System.out.println(isScramble("great", "rgeat")); // true
        System.out.println(isScramble("great", "rgate")); // true
    }
}
