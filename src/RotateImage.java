//You are given an n x n 2D matrix representing an image.
//
//        Rotate the image by 90 degrees (clockwise).
//
//        Note:
//        You have to rotate the image in-place, which means you have to modify the input 2D
//          matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//        Example 1:
//
//        Given input matrix =
//        [
//        [1,2,3],
//        [4,5,6],
//        [7,8,9]
//        ],
//
//        rotate the input matrix in-place such that it becomes:
//        [
//        [7,4,1],
//        [8,5,2],
//        [9,6,3]
//        ]
//        Example 2:
//
//        Given input matrix =
//        [
//        [ 5, 1, 9,11],
//        [ 2, 4, 8,10],
//        [13, 3, 6, 7],
//        [15,14,12,16]
//        ],
//
//        rotate the input matrix in-place such that it becomes:
//        [
//        [15,13, 2, 5],
//        [14, 3, 4, 1],
//        [12, 6, 8, 9],
//        [16, 7,10,11]
//        ]

public class RotateImage {

    // two pass, symmetric
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }

    // one pass, spiral
    public static void rotate2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < (matrix.length + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};
        rotate2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " "); // 3 1 | 4 2
            }
            System.out.println();
        }
    }
}
