
public class SearchRotatedSortedArray {
	
	// binary search
	public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (target == nums[start]) {
            return start;
        } else if (target == nums[end]) {
            return end;
        } else {
            return -1;
        }
    }
	
	// with duplicate, linear
	public static boolean search2(int[] nums, int target) {
        for (int number: nums) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }
	
	// unit test
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 2};
		int target = 5;
		int result = search(nums, target);
		System.out.println(result);
	}
}
