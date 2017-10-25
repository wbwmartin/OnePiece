import java.util.Arrays;

//Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.
//
//        Example
//        Given nums = [2, 7, 11, 15], target = 24.
//        Return 5.
//        2 + 7 < 24
//        2 + 11 < 24
//        2 + 15 < 24
//        7 + 11 < 24
//        7 + 15 < 25

public class TwoSumLessEqualTarget {

    public static int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                res += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 24;
        System.out.println(twoSum5(nums, target)); // 5
    }
}
