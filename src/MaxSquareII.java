//Given a 2D binary matrix filled with 0's and 1's, find the largest square which diagonal is all 1 and others is 0.
//
//        Notice
//
//        Only consider the main diagonal situation.
//
//        Example
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 0 1 0
//        1 1 0 0 1
//        1 0 0 1 0
//        Return 9

public class MaxSquareII {

    public static int maxSquare2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] checkDiag = new int[m + 1][n + 1];
        int[][] checkUp = new int[m + 1][n + 1];
        int[][] checkLeft = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    checkUp[i][j] = checkUp[i - 1][j] + 1;
                    checkLeft[i][j] = checkLeft[i][j - 1] + 1;
                } else {
                    checkDiag[i][j] = Math.min(checkDiag[i - 1][j - 1], Math.min(checkUp[i - 1][j], checkLeft[i][j - 1])) + 1;
                    max = Math.max(max, checkDiag[i][j]);
                }
            }
        }
        return max * max;
    }

    // unit test
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0},
                {1, 0, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0}};
        System.out.println(maxSquare2(matrix)); // 9
    }
}
