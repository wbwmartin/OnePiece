
public class UniquePath {
	
	// dp
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n ==0) {
            return 0;
        }
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            count[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }
        return count[m - 1][n - 1];
    }
    
    // dp, wigh obstacles, bad
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 0) {
                count[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 0) {
                count[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
                }
            }
        }
        return count[m - 1][n - 1];
    }
    
    // good, 1 dimension
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] count = new int[m];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            count[i] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (obstacleGrid[i][j] == 1) {
                    count[i] = 0;
                    continue;
                }
                if (i > 0) {
                    count[i] += count[i - 1];
                }
            }
        }
        return count[m - 1];
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(uniquePaths(3, 4));
    	int[][] grid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    	System.out.println(uniquePathsWithObstacles(grid));
    }
}
