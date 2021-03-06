//Given n books( the page number of each book is the same) and an array of integer with size k means k people to copy the book and the i th integer is the time i th person to copy one book). You must distribute the continuous id books to one people to copy. (You can give book A[1],A[2] to one people, but you cannot give book A[1], A[3] to one people, because book A[1] and A[3] is not continuous.) Return the number of smallest minutes need to copy all the books.
//
//        Have you met this question in a real interview? Yes
//        Example
//        Given n = 4, array A = [3,2,4], .
//
//        Return 4( First person spends 3 minutes to copy book 1, Second person spends 4 minutes to copy book 2 and 3, Third person spends 4 minutes to copy book 4. )

public class CopyBooksII {

    public static int copyBooksII(int n, int[] times) {
        int k = times.length;
        int[][] dp = new int[2][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j * times[0];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i % 2][j] = Integer.MAX_VALUE;
                for (int l = 0; l <= j; l++) {
                    dp[i % 2][j] = Math.min(dp[i % 2][j], Math.max(dp[(i - 1) % 2][j - l], times[i] * l));
                    if (dp[(i - 1) % 2][j - l] <= times[i] * l) {
                        break;
                    }
                }
            }
        }
        return dp[(k - 1) % 2][n];
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 4};
        System.out.println(copyBooksII(4, A)); // 4
    }
}
