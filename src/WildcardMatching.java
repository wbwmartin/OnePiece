import java.util.Arrays;

public class WildcardMatching {

    // dp, time O(mn), space O(m)
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][2];
        dp[0][0] = true;
        boolean[] match = new boolean[m + 1];
        Arrays.fill(match, true);
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j % 2] = match[i];
                } else {
                    dp[i][j % 2] = i > 0 && check(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][(j - 1) % 2];
                }
                match[i] = i > 0 && match[i - 1] || dp[i][j % 2];
            }
        }
        return dp[m][n % 2];
    }

    private static boolean check(char x, char y) {
        return x == y || y == '?';
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a", "*"));
    }
}
