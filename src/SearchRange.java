
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
	
	// unit test
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;
		int[] bound = searchRange(nums, target);
		for (int i: bound) {
			System.out.print(i + " ");
		}
		//long b = Math.abs(Integer.MIN_VALUE);
		//System.out.println(Math.abs(Integer.MIN_VALUE));
	}

}
