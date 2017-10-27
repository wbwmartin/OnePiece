//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
//
//        Find the maximum coins you can collect by bursting the balloons wisely.
//        - You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
//        - 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given [4, 1, 5, 10]
//        Return 270
//
//        nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
//        nums = [4, 5, 10]    burst 5, get coins 4 * 5 * 10 = 200
//        nums = [4, 10]       burst 4, get coins 1 * 4 * 10 = 40
//        nums = [10]          burst 10, get coins 1 * 10 * 1 = 10
//
//        Total coins 20 + 200 + 40 + 10 = 270

public class BurstBalloons {

    public static int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] product = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            product[i] = nums[i - 1];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 0;
            }
        }
        product[0] = 1;
        product[n + 1] = 1;
        return helper(dp, product, 1, n);
    }

    private static int helper(int[][] dp, int[] product, int i, int j) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        for (int k = i; k <= j; k++) {
            dp[i][j] = Math.max(dp[i][j], helper(dp, product, i, k - 1) + helper(dp, product, k + 1, j)
                    + product[i - 1] * product[k] * product[j + 1]);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 5, 10};
        System.out.println(maxCoins(nums)); // 270
    }
}
