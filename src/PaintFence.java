//There is a fence with n posts, each post can be painted with one of the k colors.
//        You have to paint all the posts such that no more than two adjacent fence posts have the same color.
//        Return the total number of ways you can paint the fence.
//
//        Notice
//
//        n and k are non-negative integers.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given n=3, k=2 return 6
//
//        post 1,   post 2, post 3
//        way1    0         0       1
//        way2    0         1       0
//        way3    0         1       1
//        way4    1         0       0
//        way5    1         0       1
//        way6    1         1       0

public class PaintFence {

    public static int numWays(int n, int k) {
        if (n <= 0 || k <= 0 || k == 1 && n > 2) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int[] dp = new int[3];
        dp[0] = k;
        dp[1] = k * k;
        for (int i = 2; i < n; i++) {
            dp[i % 3] = (dp[(i - 1) % 3] + dp[(i - 2) % 3]) * (k - 1);
        }
        return dp[(n - 1) % 3];
    }

    public static void main(String[] args) {
        System.out.print(numWays(3, 2)); // 6
    }
}
