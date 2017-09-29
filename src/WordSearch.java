//Given a 2D board and a word, find if the word exists in the grid.
//
//        The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//        For example,
//        Given board =
//
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//        word = "ABCCED", -> returns true,
//        word = "SEE", -> returns true,
//        word = "ABCB", -> returns false.

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String word, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        board[i][j] = '#';
        boolean res = helper(board, word, i - 1, j, pos + 1) ||
                helper(board, word, i + 1, j, pos + 1) ||
                helper(board, word, i, j - 1, pos + 1) ||
                helper(board, word, i, j + 1, pos + 1);
        board[i][j] = word.charAt(pos);
        return res;
    }

    // unit test
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word)); // true
    }
}
