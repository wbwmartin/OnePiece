//Write an efficient algorithm that searches for a value in an m x n matrix.
// This matrix has the following properties:
//
//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.
//        For example,
//
//        Consider the following matrix:
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        Given target = 5, return true.
//
//        Given target = 20, return false.

public class Search2DMatrixII {

    // binary search
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = 0;
        while (m >= 0 && n < matrix[0].length) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                m--;
            } else {
                n++;
            }
        }
        return false;
    }

    // unit test
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 5)); // true
        System.out.println(searchMatrix(matrix, 20)); // false
    }
}
