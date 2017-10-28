//Write a function, give a string A consisting of N characters and a string B consisting of M characters, returns the number of times A must be stated such that B is a substring of the repeated string. If B can never be a substring of the repeated A, then your function should return -1.
//
//        Notice
//
//        Assume that 0 <= N <= 1000, 1 <= M <= 1000
//
//        Example
//        Given A = abcd, B = cdabcdab
//
//        your function should return 3, bcause after stating string A three times we otain the string abcdabcdabcd. String B is a substring of this string.

public class RepeatString {

    public static int repeatedString(String A, String B) {
        if (B == null || B.length() == 0) {
            return 1;
        }
        if (A == null || A.length() == 0) {
            return -1;
        }
        int m = A.length();
        int n = B.length();
        int max = (n / m + 2) * m;
        boolean[][] dp = new boolean[2][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= max; i++) {
            dp[i % 2][0] = true;
            for (int j = 1; j <= n; j++) {
                dp[i % 2][j] = A.charAt((i - 1) % m) == B.charAt(j - 1) && dp[(i - 1) % 2][j - 1];
                if (j == n && dp[i % 2][j]) {
                    return (i + m - 1) / m;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        System.out.println(repeatedString(A, B)); // 3
    }
}
