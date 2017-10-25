import java.util.LinkedList;
import java.util.Queue;

//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//		A region is captured by flipping all 'O''s into 'X''s in that surrounded region.
//
//		Have you met this question in a real interview? Yes
//		Example
//		X X X X
//		X O O X
//		X X O X
//		X O X X
//		After capture all regions surrounded by 'X', the board should be:
//
//		X X X X
//		X X X X
//		X X X X
//		X O X X

public class SurroundedRegions {

    // recursive
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
            }
        }
        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                bfs(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
/*    // dfs, bad: overflow
    private static void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }*/

    // bfs, good: queue
    private static void bfs(char[][] board, int row, int col) {
        if (board[row][col] != 'O') {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        board[row][col] = '#';
        Queue<Integer> queue = new LinkedList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int code = row * n + col;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int x = code / n;
            int y = code % n;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O') {
                    queue.offer(nx * n + ny);
                    board[nx][ny] = '#';
                }
            }
        }
    }


    // unit test
    public static void main(String[] args) {
        char[][] matrix = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
