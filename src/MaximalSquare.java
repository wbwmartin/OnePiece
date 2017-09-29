//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing
// only 1's and return its area.
//
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//        Return 4.

public class MaximalSquare {

    // dp, dynamic array
    public static int maximalSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] dp = new int[2][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[i % 2][j - 1], dp[(i - 1) % 2][j])) + 1;
                    max = Math.max(max, dp[i % 2][j]);
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }
        return max * max;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[][] matrix = {{1, 0, 1}, {0, 1, 1}, {0, 1, 1}};
    	System.out.println(maximalSquare(matrix)); // 4
    }
}
