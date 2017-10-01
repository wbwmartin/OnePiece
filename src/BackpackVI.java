//Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
//
//        Notice
//
//        A number in the array can be used multiple times in the combination.
//        Different orders are counted as different combinations.
//
//        Example
//        Given nums = [1, 2, 4], target = 4
//
//        The possible combination ways are:
//        [1, 1, 1, 1]
//        [1, 1, 2]
//        [1, 2, 1]
//        [2, 1, 1]
//        [2, 2]
//        [4]
//        return 6

public class BackpackVI {

    public static int backPackVI(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int target = 4;
        System.out.println(backPackVI(nums, target)); //  6
    }
}
