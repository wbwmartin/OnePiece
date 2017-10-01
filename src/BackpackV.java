//Given n items with size nums[i] which an integer array and all positive numbers.
// An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
//
//        Each item may only be used once
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given candidate items [1,2,3,3,7] and target 7,
//
//        A solution set is:
//        [7]
//        [1, 3, 3]
//        return 2

public class BackpackV {

    public static int backPackV(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(backPackV(nums, target)); // 1
    }
}
