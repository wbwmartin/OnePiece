import java.util.ArrayList;
import java.util.List;

//Follow up for N-Queens problem.
//
//		Now, instead outputting board configurations, return the total number of distinct solutions.

public class NQueensII {

    public static int totalNQueens(int n) {
        int[] sum = {0};
        if (n <= 0) {
            return sum[0];
        }
        List<Integer> item = new ArrayList<>();
        search(item, sum, n);
        return sum[0];
    }

    private static void search(List<Integer> item, int[] sum, int n) {
        if (item.size() == n) {
            sum[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(item, i)) {
                continue;
            }
            item.add(i);
            search(item, sum, n);
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

    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens(n)); // 2
    }
}
