import java.util.HashSet;
import java.util.Set;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//        Empty cells are indicated by the character '.'.
//
//        You may assume that there will be only one unique solution.

public class SudokuSolver {

    // recursive
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length != board.length) {
            return;
        }
        helper(board);
    }

    private static boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    board[i][j] = (char) (k + '0');
                    if (isValid(board, i, j) && helper(board)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char c = board[i][col];
            if (set.contains(c)) {
                return false;
            }
            if (c >= '0' && c <= '9') {
                set.add(c);
            }
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            char c = board[row][i];
            if (set.contains(c)) {
                return false;
            }
            if (c >= '0' && c <= '9') {
                set.add(c);
            }
        }
        set.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = row - row % 3;
                int y = col - col % 3;
                char c = board[x + i][y + j];
                if (set.contains(c)) {
                    return false;
                }
                if (c >= '0' && c <= '9') {
                    set.add(c);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
