//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit.
//      You may complete as many transactions as you like
//          (ie, buy one and sell one share of the stock multiple times).
//      However, you may not engage in multiple transactions at the same time
//          (ie, you must sell the stock before you buy again).
//        Given an example [2,1,2,0,1], return 2

public class BestTimeStockII {

    // greedy, Q2
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }

    // unit test
    public static void main(String[] args) {
        int[] a = {2,1,2,0,1};
        System.out.println(maxProfit(a)); // 2
    }

}
