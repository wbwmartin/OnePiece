//Given a set of integers, write a function to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
//
//        If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
//
//        Example
//        Given nums = [1, 6, 11, 5], return 1
//
// Subset1 = [1, 5, 6], sum of Subset1 = 12
// Subset2 = [11], sum of Subset2 = 11
// abs(11 - 12) = 1

public class MinPartition {

    public static int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        int mid = sum / 2;
        boolean[] dp = new boolean[mid + 1];
        dp[0] = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = mid; j >= 0; j--) {
                dp[j] |= j - arr[i] >= 0 && dp[j - arr[i]];
            }
        }
        for (int i = mid; i >= 0; i--) {
            if (dp[i]) {
                return sum - i - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(findMin(arr)); // 1
    }
}
