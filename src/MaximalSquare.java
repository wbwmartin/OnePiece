
public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] square = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                square[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                square[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    square[i][j] = Math.min(Math.min(square[i - 1][j], square[i][j - 1]), square[i - 1][j - 1]) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                max = Math.max(max, square[i][j]);
            }
        }
        return max * max;
    }
    
    // unit test
    public static void main(String[] args) {
    	char[][] matrix = {{'1', '0', '1'}, {'0', '1', '1'}, {'0', '1', '1'}};
    	System.out.println(maximalSquare(matrix)); // 4
    }
}
