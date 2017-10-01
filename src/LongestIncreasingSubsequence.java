//Given a sequence of integers, find the longest increasing subsequence (LIS).
//
//        You code should return the length of the LIS.
//
//        Have you met this question in a real interview? Yes
//        Clarification
//        What's the definition of longest increasing subsequence?
//
//        The longest increasing subsequence problem is to find a subsequence of a given sequence
//        in which the subsequence's elements are in sorted order, lowest to highest, and in which
//        the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
//
//        https://en.wikipedia.org/wiki/Longest_increasing_subsequence
//
//        Example
//        For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
//        For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4
//
//        Challenge
//        Time complexity O(n^2) or O(nlogn)

public class LongestIncreasingSubsequence {

    // O(nlogn)
    // https://segmentfault.com/a/1190000003819886
    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] tails = new int[nums.length];
        int len = 0;
        tails[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tails[0]) {
                tails[0] = nums[i];
            } else if (nums[i] > tails[len]) {
                len++;
                tails[len] = nums[i];
            } else {
                int index = helper(tails, 0, len, nums[i]);
                tails[index] = nums[i];
            }
        }
        return len + 1;
    }

    private static int helper(int[] tails, int left, int right, int target) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] == target) {
                return mid;
            } else if (tails[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println();
    }
}




