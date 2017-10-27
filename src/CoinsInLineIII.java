//There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins.
//
//        Could you please decide the first player will win or lose?
//
//        Example
//        Given array A = [3,2,2], return true.
//
//        Given array A = [1,2,4], return true.
//
//        Given array A = [1,20,4], return false.
//
//        Challenge
//        Follow Up Question:
//
//        If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?

public class CoinsInLineIII {

    public static boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = -1;
                sum[i][j] = i == j ? values[j] : sum[i][j - 1] + values[j];
            }
        }
        int allSum = 0;
        for (int v : values) {
            allSum += v;
        }
        return allSum < 2 * helper(values, dp, sum, 0, values.length - 1);
    }

    private static int helper(int[] values, int[][] dp, int[][] sum, int i, int j) {
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        if (i > j) {
            dp[i][j] = 0;
        } else if (i == j) {
            dp[i][j] = values[i];
        } else if (i + 1 == j) {
            dp[i][j] = Math.max(values[i], values[j]);
        } else {
            int cur = Math.min(helper(values, dp, sum, i + 1, j), helper(values, dp, sum, i, j - 1));
            dp[i][j] = sum[i][j] - cur;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 2};
        int[] B = {1, 2, 4};
        int[] C = {1, 20, 4};
        System.out.println(firstWillWin(A)); // true
        System.out.println(firstWillWin(B)); // true
        System.out.println(firstWillWin(C)); // false
    }
}
