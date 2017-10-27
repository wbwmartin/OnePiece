//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
// with the colors in the order red, white and blue.
//
//        Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//        Note:
//        You are not suppose to use the library's sort function for this problem.
////
//        Follow up:
//        A rather straight forward solution is a two-pass algorithm using counting sort.
//        First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's,
//          then 1's and followed by 2's.
//
//        Could you come up with an one-pass algorithm using only constant space?

public class SortColors {

    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1, cur = 0;
        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, left, cur);
                left++;
                cur++;
            } else if (nums[cur] == 2) {
                swap(nums, cur, right);
                right--;
            } else {
                cur++;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1, 1, 2, 1, 1, 0};
        sortColors(nums);
        for (Integer i : nums) {
            System.out.print(i + " ");
        }
    }
}
