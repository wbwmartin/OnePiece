//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays.
//        The overall run time complexity should be O(log (m+n)).
//
//        Example 1:
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5

public class MedianTwoSortedArray {

    // recursive, binary search, O(log(n))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKthElement(nums1, 0, nums2, 0, len / 2) + findKthElement(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKthElement(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }

    private static int findKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int key1, key2;
        if (start1 + k / 2 - 1 < nums1.length) {
            key1 = nums1[start1 + k / 2 - 1];
        } else {
            key1 = Integer.MAX_VALUE;
        }
        if (start2 + k / 2 - 1 < nums2.length) {
            key2 = nums2[start2 + k / 2 - 1];
        } else {
            key2 = Integer.MAX_VALUE;
        }
        if (key1 < key2) {
            return findKthElement(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKthElement(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    // unit test
    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {3, 4, 5, 6, 7, 8};
        System.out.println(findMedianSortedArrays(a, b)); // 4.5
    }
}
