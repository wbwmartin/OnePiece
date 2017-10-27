import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array, adjust each integers so that the difference of every adjacent
// integers are not greater than a given number target.
//
//        If the array before adjustment is A, the array after adjustment is B,
//        you should minimize the dp of |A[i]-B[i]|
//
//        Notice
//
//        You can asdpe each number in the array is a positive integer and not greater than 100.
//
//        Example
//        Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3],
//        the adjustment cost is 2 and it's minimal.
//
//        Return 2.

public class MinAdjustmentCost {

    public static int minAdjustmentCost(List<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            return 0;
        }
        int[][] dp = new int[2][101];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j <= 100; j++) {
                if (i == 0) {
                    dp[0][j] = Math.abs(A.get(0) - j);
                } else {
                    dp[i % 2][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= 100; k++) {
                        if (Math.abs(j - k) <= target) {
                            int diff = dp[(i - 1) % 2][k] + Math.abs(A.get(i) - j);
                            dp[i % 2][j] = Math.min(dp[i % 2][j], diff);
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, dp[(A.size() - 1) % 2][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        int target = 1;
        System.out.println(minAdjustmentCost(A, target)); // 2
    }
}
