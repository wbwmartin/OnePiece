
public class Search2DMatrix {
	
	// binary search once
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int number = matrix[mid / n][mid % n];
            if (target == number) {
                return true;
            } else if (target > number) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
            return true;
        }
        return false;
    }
	
	// different sorting, return #occurence
	public int searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        int res = 0;
        while (row >= 0 && col < matrix[0].length) {
            int number = matrix[row][col];
            if (number == target) {
                res++;
                row--;
                col++;
            } else if (number > target) {
                row--;
            } else {
                col++;
            }
        }
        return res;
    }

	// unit test
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int target = 3;
		boolean result = searchMatrix(matrix, target);
		System.out.println(result);
	}
}
