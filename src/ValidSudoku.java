import java.util.Arrays;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[i][j])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[j][i])) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!isValid(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(boolean[] visited, char digit) {
        if (digit == '.') {
            return true;
        }
        int num = digit - '0';
        if (num > 9 || num < 1 || visited[num - 1]) {
            return false;
        }
        visited[num - 1] = true;
        return true;
    }

    public static void main(String[] args) {

    }
}
