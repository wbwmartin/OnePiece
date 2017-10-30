//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit.
//          You may complete at most k transactions.
//
//        You may not engage in multiple transactions at the same time
//          (i.e., you must sell the stock before you buy again).
//
//        Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

public class BestTimeStockIV {

    // dp, Q4
    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length) {
            return helper(prices);
        }
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = Math.min(i, k); j > 0; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }

    private static int helper(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {4, 4, 6, 1, 1, 4, 2, 5};
        System.out.println(maxProfit(2, a)); // 6
    }
}
