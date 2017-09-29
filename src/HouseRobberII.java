// Note: This is an extension of House Robber.
//
//        After robbing those houses on that street, the thief has found himself
// a new place for his thievery so that he will not get too much attention.
// This time, all houses at this place are arranged in a circle.
// That means the first house is the neighbor of the last one.
// Meanwhile, the security system for these houses remain the same as for
// those in the previous street.
//
//        Given a list of non-negative integers representing the amount of money
// of each house, determine the maximum amount of money you can rob tonight without
// alerting the police.

public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private static int helper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        if (left + 1 == right) {
            return Math.max(nums[left], nums[right]);
        }
        int[] dp = new int[2];
        dp[left % 2] = nums[left];
        dp[(left + 1) % 2] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[i % 2] + nums[i]);
        }
        return Math.max(dp[0], dp[1]);
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 6};
        System.out.println(rob(nums)); // 7
    }
}
