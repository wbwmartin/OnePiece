import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of integers, find two non-overlapping subarrays which have the largest sum.
//        The number in each subarray should be contiguous.
//        Return the largest sum.
//
//        Notice
//
//        The subarray should contain at least one number
//
//        Example
//        For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or
//          [1, 3, -1, 2] and [2], they both have the largest sum 7.
//
//        Challenge
//        Can you do it in time complexity O(n) ?

public class MaxSubarrayII {

    public static int maxTwoSubArrays(List<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] left = new int[nums.size()];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            sum = Math.max(sum + nums.get(i), nums.get(i));
            max = Math.max(max, sum);
            left[i] = max;
        }
        max = nums.get(nums.size() - 1);
        sum = 0;
        for (int i = nums.size() - 2; i >= 0; i--) {
            sum = Math.max(sum + nums.get(i + 1), nums.get(i + 1));
            max = Math.max(max, sum);
            res = Math.max(res, left[i] + max);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] a = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        List<Integer> res = new ArrayList<>(Arrays.asList(a));
        System.out.println(maxTwoSubArrays(res)); // 9
    }
}
