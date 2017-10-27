//Given a sorted array and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the array.
//
//        Here are few examples.
//        [1,3,5,6], 5 → 2
//        [1,3,5,6], 2 → 1
//        [1,3,5,6], 7 → 4
//        [1,3,5,6], 0 → 0


public class SearchInsertPosition {

    // binary search
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int result = searchInsert(nums, target);
        System.out.println(result); // 0
    }

}
