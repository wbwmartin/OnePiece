import java.util.ArrayList;
import java.util.List;

//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that
// no two queens attack each other.
//
//        Given an integer n, return all distinct solutions to the n-queens puzzle.
//
//        Each solution contains a distinct board configuration of the n-queens' placement,
//        where 'Q' and '.' both indicate a queen and an empty space respectively.
//
//        For example,
//        There exist two distinct solutions to the 4-queens puzzle:
//
//        [
//        [".Q..",  // Solution 1
//        "...Q",
//        "Q...",
//        "..Q."],
//
//        ["..Q.",  // Solution 2
//        "Q...",
//        "...Q",
//        ".Q.."]
//        ]

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        List<Integer> item = new ArrayList<>();
        search(res, item, n);
        return res;
    }

    private static void search(List<List<String>> res, List<Integer> item, int n) {
        if (item.size() == n) {
            res.add(draw(item));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(item, i)) {
                continue;
            }
            item.add(i);
            search(res, item, n);
            item.remove(item.size() - 1);
        }
    }

    private static boolean isValid(List<Integer> item, int col) {
        int row = item.size();
        for (int i = 0; i < row; i++) {
            if (item.get(i) == col) {
                return false;
            }
            if (i + item.get(i) == row + col) {
                return false;
            }
            if (i - item.get(i) == row - col) {
                return false;
            }
        }
        return true;
    }

    private static List<String> draw(List<Integer> item) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < item.size(); i++) {
            String temp = "";
            for (int j = 0; j < item.size(); j++) {
                if (j == item.get(i)) {
                    temp += "Q";
                } else {
                    temp += ".";
                }
            }
            list.add(temp);
        }
        return list;
    }

    // unit test
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
