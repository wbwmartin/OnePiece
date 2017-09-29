import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int levelNum = Math.min(m, n) / 2;
        for (int level = 0; level < levelNum; level++) {
            for (int i = level; i < n - level - 1; i++) {
                res.add(matrix[level][i]);
            }
            for (int i = level; i < m - level - 1; i++) {
                res.add(matrix[i][n - 1 - level]);
            }
            for (int i = n - level - 1; i > level; i--) {
                res.add(matrix[m - 1 - level][i]);
            }
            for (int i = m - level - 1; i > level; i--) {
                res.add(matrix[i][level]);
            }
        }
        if (Math.min(m, n) % 2 == 1) {
            if (m < n) {
                for (int i = levelNum; i < n - levelNum; i++) {
                    res.add(matrix[levelNum][i]);
                }
            } else {
                for (int i = levelNum; i < m - levelNum; i++) {
                    res.add(matrix[i][levelNum]);
                }
            }
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ++n;
            }
        }
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res); // 1 2 3 6 9 8 7 4 5
    }
}
