//There is a stone game.At the beginning of the game the player picks n piles of stones in a line.
//
//        The goal is to merge the stones in one pile observing the following rules:
//
//        At each step of the game,the player can merge two adjacent piles to a new pile.
//        The score is the number of stones in the new pile.
//        You are to determine the minimum of the total score.
//
//        Have you met this question in a real interview? Yes
//        Example
//        For [4, 1, 1, 4], in the best solution, the total score is 18:
//
//        1. Merge second and third piles => [4, 2, 4], score +2
//        2. Merge the first two piles => [6, 4]，score +6
//        3. Merge the last two piles => [10], score +10
//        Other two examples:
//        [1, 1, 1, 1] return 8
//        [4, 4, 5, 9] return 43

public class StoneGame {

    public static int stoneGame(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            sum[i][i] = A[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = -1;
                sum[i][j] = sum[i][j - 1] + A[j];
            }
        }
        return helper(dp, sum, 0, n - 1);
    }

    private static int helper(int[][] dp, int[][] sum, int i, int j) {
        if (dp[i][j] >= 0) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(dp[i][j], helper(dp, sum, i, k) + helper(dp, sum, k + 1, j) + sum[i][j]);
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 1, 4};
        System.out.println(stoneGame(A)); // 18
    }
}
