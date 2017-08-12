
public class MaximalRectangle {

	public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }
            max = Math.max(max, LargestRectangleHistogram.largestRectangleArea(height));
        }
        return max;
    }
	
    // unit test
    public static void main(String[] args) {
    	char[][] matrix = {{'0', '1', '0'}, {'0', '1', '1'}, {'1', '1', '0'}};
    	System.out.println(maximalRectangle(matrix)); // 3
    }
	
}
