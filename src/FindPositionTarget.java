//For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
//
//        If the target number does not exist in the array, return -1.
//
//        Example
//        If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
//
//        Challenge
//        If the count of numbers is bigger than 2^32, can your code work properly?

public class FindPositionTarget {

    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
        int target = 3;
        System.out.println(binarySearch(nums, target)); // 2
    }
}
