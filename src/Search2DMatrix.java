//Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//        For example,
//
//        Consider the following matrix:
//
//        [
//        [1,   3,  5,  7],
//        [10, 11, 16, 20],
//        [23, 30, 34, 50]
//        ]
//        Given target = 3, return true.

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

    // unit test
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        boolean result = searchMatrix(matrix, target);
        System.out.println(result); // true
    }
}
