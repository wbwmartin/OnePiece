//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//        Example:
//        Given nums = [-2, 0, 3, -5, 2, -1]
//
//        sumRange(0, 2) -> 1
//        sumRange(2, 5) -> -1
//        sumRange(0, 5) -> -3
//        Note:
//        You may assume that the array does not change.
//        There are many calls to sumRange function.

public class RangeSumQueryImmutable {

    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i > j) {
            return -1;
        }
        return sum[j + 1] - sum[i];
    }
}
