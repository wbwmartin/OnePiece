//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        For example,
//        Given [5, 7, 7, 8, 8, 10] and target value 8,
//        return [3, 4].


public class SearchRange {

    // binary search
    public static int[] searchRange(int[] nums, int target) {
        int[] bound = {-1, -1};
        if (nums == null || nums.length == 0) {
            return bound;
        }
        int start, end, mid;
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            bound[0] = start;
        } else if (nums[end] == target) {
            bound[0] = end;
        }

        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        }

        return bound;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] bound = searchRange(nums, target);
        for (int i : bound) {
            System.out.print(i + " "); // 3 4
        }
    }

}
