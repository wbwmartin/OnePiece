//Rotate an array of n elements to the right by k steps.
//
//        For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//        Note:
//        Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

public class RotateArray {

    public static void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = (i - k + 1) % n;
            if (nums[i] <= 0) {
                nums[i] += n;
            }
        }
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            left++;
            right--;
        }
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 17;
        rotate(nums, k);
        for (Integer i : nums) {
            System.out.print(i + " "); // 5 6 7 1 2 3 4
        }
    }
}
