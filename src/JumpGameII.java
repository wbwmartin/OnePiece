//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Your goal is to reach the last index in the minimum number of jumps.
//
//        For example:
//        Given array A = [2,3,1,1,4]
//
//        The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
//        then 3 steps to the last index.)
//
//        Note:
//        You can assume that you can always reach the last index.


public class JumpGameII {

    // dp, greedy
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[nums.length - 1];
    }

    // greedy, O(n) http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html
    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int res = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > last) {
                last = curr;
                res++;
            }
            curr = Math.max(curr, i + nums[i]);
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 1, 4};
        System.out.println(jump2(A)); // 2
    }
}
