//Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//        Solve it without division and in O(n).
//
//        For example, given [1,2,3,4], return [24,12,8,6].
//
//        Follow up:
//        Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        for (Integer i : productExceptSelf(a)) {
            System.out.print(i + " "); // 24 12 8 6
        }
    }
}
