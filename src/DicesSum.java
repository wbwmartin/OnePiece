import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicesSum {

    public static List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> results = new ArrayList<>();
        double[][] dp = new double[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1.0 / 6;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
                dp[i][j] /= 6.0;
            }
        }
        for (int i = n; i <= 6 * n; i++) {
            results.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]));
        }
        return results;
    }

}
