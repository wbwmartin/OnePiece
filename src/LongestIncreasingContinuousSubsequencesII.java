//Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
//
//        Example
//        Given a matrix:
//
//        [
//        [1 ,2 ,3 ,4 ,5],
//        [16,17,24,23,6],
//        [15,18,25,22,7],
//        [14,19,20,21,8],
//        [13,12,11,10,9]
//        ]
//        return 25
//
//        Challenge
//        O(nm) time and memory.

public class LongestIncreasingContinuousSubsequencesII {

    // memoization, O(mn) time and memory
    public static int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = search(i, j, A, dp, visited);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    private static int search(int x, int y, int[][] A, int[][] dp, boolean[][] visited) {
        if (visited[x][y]) {
            return dp[x][y];
        }
        int m = A.length;
        int n = A[0].length;
        int res = 1;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                if (A[x][y] > A[nx][ny]) {
                    res = Math.max(res, search(nx, ny, A, dp, visited) + 1);
                }
            }
        }
        visited[x][y] = true;
        dp[x][y] = res;
        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3, 4, 5}, {16, 17, 24, 23, 6}, {15, 18, 25, 22, 7},
                {14, 19, 20, 21, 8}, {13, 12, 11, 10, 9}};
        System.out.println(longestIncreasingContinuousSubsequenceII(A)); // 25
    }

}
