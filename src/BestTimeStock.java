
public class BestTimeStock {

	// dp, Q1
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - low > profit) {
                profit = prices[i] - low;
            }
            if (prices[i] < low) {
                low = prices[i];
            }
        }
        return profit;
	}
    
    // greedy, Q2
    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    
    // dp, Q3
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int low = prices[0];
        int[] arrayA = new int[n];
        for (int i = 1; i < n; i++) {
            arrayA[i] = Math.max(arrayA[i - 1], prices[i] - low);
            if (prices[i] < low) {
                low = prices[i];
            }
        }
        int high = prices[n - 1];
        int[] arrayB = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            arrayB[i] = Math.max(arrayB[i + 1], high - prices[i]);
            if (prices[i] > high) {
                high = prices[i];
            }
        }
        int profit = 0;
        for (int i = 0; i < n; i++) {
            if (arrayA[i] + arrayB[i] > profit) {
                profit = arrayA[i] + arrayB[i];
            }
        }
        return profit;
    }
    
    // dp, Q4
    public static int maxProfit4(int k, int[] prices) {
    	if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length) {
        	return maxProfit2(prices);
        }        
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];       
        for (int i = 1; i < prices.length ; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = k; j > 0; j--) {
                local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
                global[j] = Math.max(global[j], local[j]);
            }
        }        
        return global[k];
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] a = {2, 3, 5, 1, 6};
    	System.out.println(maxProfit(a));
    	System.out.println(maxProfit2(a));
    	System.out.println(maxProfit3(a));
    	int[] b = {1, 5, 2, 3, 10};
    	System.out.println(maxProfit4(2, b));
    }

}
