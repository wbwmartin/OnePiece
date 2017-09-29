//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        Find the minimum element.
//
//        You may assume no duplicate exists in the array.

public class FindMinRotatedSortedArray {

    // binary search
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    // unit test
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // 0
        System.out.println(findMin(nums));
    }

}
