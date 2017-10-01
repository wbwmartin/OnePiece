//Given two strings, find the longest common subsequence (LCS).
//
//        Your code should return the length of LCS.
//
//        Clarification
//        What's the definition of Longest Common Subsequence?
//
//        https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
//        http://baike.baidu.com/view/2020307.htm
//        Example
//        For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
//
//        For "ABCD" and "EACB", the LCS is "AC", return 2.


public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ABCD", "EDCA")); // 1
        System.out.println(longestCommonSubsequence("ABCD", "EACB")); // 2
    }
}
