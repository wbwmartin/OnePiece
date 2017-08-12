//Say you have an array for which the ith element is the price of a given stock on day i.
//
//       If you were only permitted to complete at most one transaction
//      (ie, buy one and sell one share of the stock),
//      design an algorithm to find the maximum profit.
//        Given array [3,2,3,1,2], return 1.

public class BestTimeStock {

    // dp, Q1
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - low);
            low = Math.min(low, prices[i]);
        }
        return profit;
    }

    // unit test
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 6};
        System.out.println(maxProfit(a));
    }

}
