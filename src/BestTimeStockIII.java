//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit.
// You may complete at most two transactions.
//
//        You may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).
//
//        Given an example [4,4,6,1,1,4,2,5], return 6.

public class BestTimeStockIII {
    // dp, Q3
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int low = prices[0];
        int[] arrayA = new int[n]; // max profit before each day
        for (int i = 1; i < n; i++) {
            arrayA[i] = Math.max(arrayA[i - 1], prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        int high = prices[n - 1];
        int[] arrayB = new int[n]; // max profit after each day
        for (int i = n - 2; i >= 0; i--) {
            arrayB[i] = Math.max(arrayB[i + 1], high - prices[i]);
            high = Math.max(high, prices[i]);
        }
        int profit = 0;
        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, arrayA[i] + arrayB[i]); // add two transactions
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] a = {4,4,6,1,1,4,2,5};
        System.out.println(maxProfit(a)); // 6
    }
}
