import java.util.Arrays;

//There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.
//
//        Could you please decide the first player will win or lose?
//
//
//        Example
//        Given values array A = [1,2,2], return true.
//
//        Given A = [1,2,4], return false.

public class CoinsInLineII {

    public static boolean firstWillWin(int[] values) {
        if (values == null || values.length == 0) {
            return false;
        }
        int[] dp = new int[values.length + 1];
        Arrays.fill(dp, -1);
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum < 2 * helper(values, dp, values.length);
    }

    // memoization, pruning
    private static int helper(int[] values, int[] dp, int k) {
        if (dp[k] >= 0) {
            return dp[k];
        }
        int n = values.length;
        if (k == 0) {
            dp[k] = 0;
        } else if (k == 1) {
            dp[k] = values[n - 1];
        } else if (k == 2) {
            dp[k] = values[n - 1] + values[n - 2];
        } else if (k == 3) {
            dp[k] = values[n - 2] + values[n - 3];
        } else {
            dp[k] = Math.max(
                    Math.min(helper(values, dp, k - 2), helper(values, dp, k - 3)) + values[n - k],
                    Math.min(helper(values, dp, k - 3), helper(values, dp, k - 4)) + values[n - k] + values[n - k + 1]
            );
        }
        return dp[k];
    }

    public static void main(String[] args) {
        int[] A1 = {1, 2, 2};
        int[] A2 = {1, 2, 4};
        System.out.println(firstWillWin(A1)); // true
        System.out.println(firstWillWin(A2)); // false
    }
}
