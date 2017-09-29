//Given an unsorted integer array, find the first missing positive integer.
//
//        For example,
//        Given [1,2,0] return 3,
//        and [3,4,-1,1] return 2.
//
//        Your algorithm should run in O(n) time and uses constant space.

public class FirstMissingPositive {

    // iterative
    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] > 0
                    && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums)); // 2
    }
}
