import java.util.ArrayList;


public class MinAdjustmentCost {

	public int minAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) {
            return 0;
        }
        int[][] sum = new int[A.size()][101];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 1; j <= 100; j++) {
                if (i == 0) {
                    sum[i][j] = Math.abs(A.get(i) - j);
                } else {
                    sum[i][j] = Integer.MAX_VALUE;
                    for (int k = 1; k <= 100; k++) {
                        if (Math.abs(j - k) > target) {
                            continue;
                        }
                        int diff = sum[i - 1][k] + Math.abs(A.get(i) - j);
                        sum[i][j] = Math.min(sum[i][j], diff);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            res = Math.min(res, sum[A.size() - 1][i]);
        }
        return res;
    }
}
