//Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?
//
//        Notice
//
//        You can not divide any item into small pieces.
//
//        Example
//        If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select
// [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12.
// we can select [2, 3, 7] so that we can fulfill the backpack.
//
//        You function should return the max size we can fill in the given backpack.
//
//        Challenge
//        O(n x m) time and O(m) memory.
//
//        O(n x m) memory is also acceptable if you do not know how to optimize memory.

public class Backpack {

    public static int backPack(int m, int[] A) {
        if (A == null || A.length == 0 || m < 0) {
            return 0;
        }
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= 0; j--) {
                dp[j] |= j - A[i] >= 0 && dp[j - A[i]];
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int m = 11;
        int[] A = {2, 3, 5, 7};
        System.out.println(backPack(m, A)); // 10
    }
}
