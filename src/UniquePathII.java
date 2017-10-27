//Follow up for "Unique Paths":
//
//        Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//        An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//        For example,
//        There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//        [
//        [0,0,0],
//        [0,1,0],
//        [0,0,0]
//        ]
//        The total number of unique paths is 2.

public class UniquePathII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] count = new int[n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            count[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {

                    count[j] = 0;
                    continue;
                }
                if (j > 0) {
                    count[j] += count[j - 1];
                }
            }
        }
        return count[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(grid)); // 2
    }
}
