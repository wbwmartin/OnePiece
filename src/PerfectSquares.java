//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given n = 12, return 3 because 12 = 4 + 4 + 4
//        Given n = 13, return 2 because 13 = 4 + 9

public class PerfectSquares {

    public static int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 0; i * i <= n; i++) {
            int j = (int) Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                return i == 0 ? 1 : 2;
            }
        }
        return 3;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12)); // 3
        System.out.println(numSquares(13)); // 2
    }
}
