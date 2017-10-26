//Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits. You should try to optimize your time and space complexity.
//
//
//        Example
//        Given nums1 = [3, 4, 6, 5], nums2 = [9, 1, 2, 5, 8, 3], k = 5
//        return [9, 8, 6, 5, 3]
//
//        Given nums1 = [6, 7], nums2 = [6, 0, 4], k = 5
//        return [6, 7, 6, 0, 4]
//
//        Given nums1 = [3, 9], nums2 = [8, 9], k = 3
//        return [9, 8, 9]

public class CreateMaxNumber {

    // https://www.hrwhisper.me/leetcode-create-maximum-number/
    // O((m + n)^3)
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // write your code here
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(m, k); i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(temp, 0, res, 0)) {
                res = temp;
            }
        }
        return res;
    }

    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || i < nums1.length && nums1[i] > nums2[j];
    }

    // monotonous stack idea
    private static int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < n; i++) {
            while (len > 0 && len + n - i > k && nums[i] > res[len - 1]) {
                len--;
            }
            if (len < k) {
                res[len] = nums[i];
                len++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] res = maxNumber(nums1, nums2, k);
        for (int i : res) {
            System.out.print(i + " "); // 9 8 6 5 3
        }
    }
}
