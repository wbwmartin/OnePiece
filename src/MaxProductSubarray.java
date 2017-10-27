//Find the contiguous subarray within an array (containing at least one number)
//        which has the largest product.
//
//        For example, given the array [2,3,-2,4],
//        the contiguous subarray [2,3] has the largest product = 6.

public class MaxProductSubarray {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(temp * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, -2, 4}; // 6
        System.out.println(maxProduct(a));
    }

}
