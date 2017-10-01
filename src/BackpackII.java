//Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?
//
//        Notice
//
//        You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
//
//        Challenge
//        O(n x m) memory is acceptable, can you do it in O(m) memory?


public class BackpackII {

    public static int backPackII(int m, int[] A, int V[]) {
        if (A == null || A.length == 0 || V == null || V.length == 0 || A.length != V.length || m <= 0) {
            return 0;
        }
        boolean[] check = new boolean[m + 1];
        check[0] = true;
        int[] dp = new int[m + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i] >= 0 && check[j - A[i]]) {
                    check[j] = true;
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int m = 10;
        int[] A = {2, 3, 5, 7};
        int[] V = {1, 5, 2, 4};
        System.out.println(backPackII(m, A, V)); // 9
    }
}
