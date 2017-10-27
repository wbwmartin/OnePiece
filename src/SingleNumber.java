//Given an array of integers, every element appears twice except for one. Find that single one.
//
//        Note:
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class SingleNumber {

    // Q1
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int x : nums) {
            sum ^= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 2, 5, 2};
        int[] b = {1, 3, 2, 3, 3, 1, 1};
        System.out.println(singleNumber(a)); // 5
    }
}
