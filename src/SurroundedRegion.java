import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegion {

	// recursive
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            helper2(board, i, 0);
            helper2(board, i, n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            helper2(board, 0, j);
            helper2(board, m - 1, j);
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
    private static void helper(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        helper(board, row + 1, col);
        helper(board, row - 1, col);
        helper(board, row, col + 1);
        helper(board, row, col - 1);
    }*/
    
    // bfs, good: queue
    private static void helper2(char[][] board, int row, int col) {
    	if (board[row][col] != 'O') {
    		return;
    	}
    	board[row][col] = '#';
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int code = row * board[0].length + col;
    	queue.offer(code);
    	while (!queue.isEmpty()) {
    		code = queue.poll();
    		int i = code / board[0].length;
    		int j = code % board[0].length;
    		if (i > 0 && board[i - 1][j] == 'O') {
    			queue.offer((i - 1) * board[0].length + j);
    			board[i - 1][j] = '#';
    		}
    		if (i < board.length - 1 && board[i + 1][j] == 'O') {
    			queue.offer((i + 1) * board[0].length + j);
    			board[i + 1][j] = '#';
    		}
    		if (j > 0 && board[i][j - 1] == 'O') {
    			queue.offer(i * board[0].length + j - 1);
    			board[i][j - 1] = '#';
    		}
    		if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
    			queue.offer(i * board[0].length + j + 1);
    			board[i][j + 1] = '#';
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
