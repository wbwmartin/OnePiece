//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//        A subsequence of a string is a new string which is formed from the original string by
// deleting some (can be none) of the characters without disturbing the relative positions of
// the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//        Example
//        Given S = "rabbbit", T = "rabbit", return 3.
//
//        Challenge
//        Do it in O(n2) time and O(n) memory.
//
//        O(n2) memory is also acceptable if you do not know how to optimize memory.

public class DistinctSubsequences {

    public static int numDistinct(String S, String T) {
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for (int j = 0; j <= S.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = i; j <= S.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }

    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        System.out.print(numDistinct(S, T)); // 3
    }

}
