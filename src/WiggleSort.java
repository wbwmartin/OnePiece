//Given an unsorted array nums, reorder it in-place such that
//
//        nums[0] <= nums[1] >= nums[2] <= nums[3]....
//        Notice
//
//        Please complete the problem in-place.
//
//        Example
//        Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

public class WiggleSort {

    public static void wiggleSort(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 1 && nums[i - 1] > nums[i] || (i & 1) == 0 && nums[i - 1] < nums[i]) {
                swap(nums, i - 1, i);
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        for (int i : nums) {
            System.out.print(i + " "); // 3 5 1 6 2 4
        }
    }
}
