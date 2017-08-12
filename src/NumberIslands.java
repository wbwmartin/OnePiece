
public class NumberIslands {

	// dfs
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void helper(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        helper(grid, visited, i + 1, j);
        helper(grid, visited, i - 1, j);
        helper(grid, visited, i, j + 1);
        helper(grid, visited, i, j - 1);
    }
    
    // unit test
    public static void main(String[] args) {
    	char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, 
    			{'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
    	System.out.println(numIslands(grid)); // 3
    }
}
