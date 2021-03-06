//You are climbing a stair case. It takes n steps to reach to the top.
//
//        Each time you can either climb 1 or 2 steps.
//          In how many distinct ways can you climb to the top?
//
//        Note: Given n will be a positive integer.
public class ClimbingStairs {

    // dp
    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            count[i] = count[i - 1] + count[i - 2];
        }
        return count[n];
    }

    // dp, good
    public static int climbStairs2(int n) {
        if (n < 1) {
            return 0;
        }
        int sum1 = 0;
        int sum2 = 1;
        for (int i = 1; i <= n; i++) {
            int temp = sum1 + sum2;
            sum1 = sum2;
            sum2 = temp;
        }
        return sum2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5)); // 8
    }
}
