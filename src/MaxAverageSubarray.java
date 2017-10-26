//Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.
//
//        Notice
//
//        It's guaranteed that the size of the array is greater or equal to k.
//
//        Example
//        Given nums = [1, 12, -5, -6, 50, 3], k = 3
//
//        Return 15.667 // (-6 + 50 + 3) / 3 = 15.667

public class MaxAverageSubarray {

    // O(nlog(max - min)), binary search by value
    public static double maxAverage(int[] nums, int k) {
        double l = Integer.MAX_VALUE;
        double r = Integer.MIN_VALUE;
        double res = 0;
        for (int n : nums) {
            if (n < l) {
                l = n;
            }
            if (n > r) {
                r = n;
            }
            res += n;
        }
        if (nums.length == k) {
            return res / k;
        }
        double[] sum = new double[nums.length + 1];
        while (r - l >= 1e-6) {
            double mid = l + (r - l) / 2;
            boolean check = false;
            double min_pre = 0;
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1] - mid;
                if (i > k) {
                    min_pre = Math.min(min_pre, sum[i - k]);
                    if (sum[i] - min_pre >= 0) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 3;
        System.out.println(maxAverage(nums, k)); // 15.667
    }

}
