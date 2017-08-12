
public class FindPeakElement {
	
	// binary search
	public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        } else {
            return end;
        }
    }
	
	// unit test
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 1};
		int result = findPeakElement(nums);
		System.out.println(result);
	}
}
