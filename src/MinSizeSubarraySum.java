//Given an array of n positive integers and a positive integer s, find the minimal length
// of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        For example, given the array [2,3,1,2,4,3] and s = 7,
//        the subarray [4,3] has the minimal length under the problem constraint.
//
//        click to show more practice.
//
//        More practice:
//        If you have figured out the O(n) solution, try coding another solution of which
//          the time complexity is O(n log n).

public class MinSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                len = Math.min(len, j - i);
            }
            sum -= nums[i];
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println(minSubArrayLen(s, nums)); // 2
    }
}
