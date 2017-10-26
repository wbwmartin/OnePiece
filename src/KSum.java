//Given n distinct positive integers, integer k (k <= n) and a number target.
//
//        Find k numbers where sum is target. Calculate how many solutions there are?
//
//
//        Example
//        Given [1,2,3,4], k = 2, target = 5.
//
//        There are 2 solutions: [1,4] and [2,3].
//
//        Return 2.

public class KSum {

    public static int kSum(int A[], int k, int target) {
        int n = A.length;
        int dp[][][] = new int[n + 1][k + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][j][t] = dp[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        dp[i][j][t] += dp[i - 1][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        return dp[n][k][target];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int k = 2;
        int target = 5;
        System.out.println(kSum(A, k, target)); // 2
    }
}
