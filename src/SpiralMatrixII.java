import java.util.List;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int levelNum = n / 2;
        int num = 1;
        for (int level = 0; level < levelNum; level++) {
            for (int i = level; i < n - level - 1; i++) {
                res[level][i] = num;
                num++;
            }
            for (int i = level; i < n - level - 1; i++) {
                res[i][n - 1 - level] = num;
                num++;
            }
            for (int i = n - level - 1; i > level; i--) {
                res[n - 1 - level][i] = num;
                num++;
            }
            for (int i = n - level - 1; i > level; i--) {
                res[i][level] = num;
                num++;
            }
        }
        if (n % 2 == 1) {
            res[levelNum][levelNum] = num;
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int m = 3;
        int[][] res = generateMatrix(m);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " "); // 1 2 3 | 8 9 4 | 7 6 5
            }
            System.out.println();
        }
    }
}
