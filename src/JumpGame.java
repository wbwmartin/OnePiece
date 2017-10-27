//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//        For example:
//        A = [2,3,1,1,4], return true.
//
//        A = [3,2,1,0,4], return false.


public class JumpGame {

    // dp
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && nums[j] >= i - j) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[nums.length - 1];
    }

    // greedy
    public static boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int fastest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (fastest >= i && i + nums[i] > fastest) {
                fastest = i + nums[i];
            }
        }
        return fastest >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        int[] B = {3, 2, 1, 0, 4};
        System.out.println(canJump2(A)); // true
        System.out.println(canJump2(B)); // false
    }
}
