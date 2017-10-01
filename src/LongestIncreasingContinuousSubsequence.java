//Give an integer array，find the longest increasing continuous subsequence in this array.
//
//        An increasing continuous subsequence:
//
//        Can be from right to left or from left to right.
//        Indices of the integers in the subsequence should be continuous.
//        Notice
//
//        O(n) time and O(1) extra space.
//
//        Have you met this question in a real interview? Yes
//        Example
//        For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
//
//        For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

public class LongestIncreasingContinuousSubsequence {

    public static int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 1;
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            res = Math.max(res, len);
        }
        len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                len++;
            } else {
                len = 1;
            }
            res = Math.max(res, len);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 2, 1, 3};
        System.out.println(longestIncreasingContinuousSubsequence(A)); // 4
    }
}
