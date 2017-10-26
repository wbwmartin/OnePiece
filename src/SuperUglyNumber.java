//Ugly number is a number that only have factors 2, 3 and 5.
//
//        Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
//
//        Notice
//
//Write a program to find the nth super ugly number.
//
//        Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
//
//        Notice
//
//        1 is a super ugly number for any given primes.
//        The given numbers in primes are in ascending order.
//        0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000
//
//        Example
//        Given n = 6, primes = [2, 7, 13, 19] return 13


public class SuperUglyNumber {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] nums = new int[n];
        int[] positions = new int[primes.length];
        nums[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, nums[positions[j]] * primes[j]);
            }
            nums[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (nums[positions[j]] * primes[j] == min) {
                    positions[j]++;
                }
            }
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(n, primes)); // 13
    }
}
