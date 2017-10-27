//Given two strings, find the longest common substring.
//
//        Return the length of it.
//
//        Notice
//
//        The characters in substring should occur continuously in original string. This is different with subsequence.
//
//        Example
//        Given A = "ABCD", B = "CBCE", return 2.
//
//        Challenge
//        O(n x m) time and memory.

public class LongestCommonSubstring {

    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String A = "ABCD";
        String B = "CBCE";
        System.out.println(longestCommonSubstring(A, B)); // 2
    }
}
