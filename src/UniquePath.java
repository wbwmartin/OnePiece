//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//        How many possible unique paths are there?

public class UniquePath {
	
	// dp
    public static int uniquePaths(int m, int n) {
        if (m == 0 || n ==0) {
            return 0;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                res[i] += res[i - 1];
            }
        }
        return res[n - 1];
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(uniquePaths(3, 3)); // 6
        System.out.println(uniquePaths(4, 5)); // 35
    }
}
