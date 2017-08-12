
public class WordSearch {

	// recursive
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = helper(board, word, i, j, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean helper(char[][] board, String word, int i, int j, int start) {
        if (start == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }
        board[i][j] = '#';
        boolean res = helper(board, word, i - 1, j, start + 1)
                || helper(board, word, i + 1, j, start + 1)
                || helper(board, word, i, j - 1, start + 1)
                || helper(board, word, i, j + 1, start + 1);
        board[i][j] = word.charAt(start);
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    	String word = "ABCCED";
    	System.out.println(exist(board, word));
    }
}
