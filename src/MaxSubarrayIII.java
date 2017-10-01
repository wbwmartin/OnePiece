//Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.
//
//        The number in each subarray should be contiguous.
//
//        Return the largest sum.
//
//        Notice
//
//        The subarray should contain at least one number
//
//        Example
//        Given [-1,4,-2,3,-2,3], k=2, return 8

public class MaxSubarrayIII {

    public static int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        int n = nums.length;
        int[][] global = new int[k + 1][n + 1];
        int[][] local = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            local[i][i - 1] = Integer.MIN_VALUE;
            for (int j = i; j <= n; j++) {
                local[i][j] = Math.max(local[i][j - 1], global[i - 1][j - 1]) + nums[j - 1];
                if (i == j) {
                    global[i][j] = local[i][j];
                } else {
                    global[i][j] = Math.max(global[i][j - 1], local[i][j]);
                }
            }
        }
        return global[k][n];
    }

    public static void main(String[] args) {
        int[] nums = {-1, 4, -2, 3, -2, 3};
        int k = 2;
        System.out.println(maxSubArray(nums, k)); // 8
    }
}
