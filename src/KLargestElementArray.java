
public class KLargestElementArray {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return 0;
        }
        return getK(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    
    private static int getK(int[] nums, int k, int start, int end) {
    	int left = start;
    	int right = end;
    	int pivot = left;
    	while (left < right) {
    		while (nums[left] < nums[pivot]) {
    			left++;
    		}
    		while (nums[right] > nums[pivot]) {
    			right--;
    		}
    		swap(nums, left, right);
    	}
    	swap(nums, pivot, right);
    	if (right + 1 == k) {
    		return nums[pivot];
    	} else if (right + 1 > k) {
    		return getK(nums, k, start, right);
    	} else {
    		return getK(nums, k, left + 1, end);
    	}
    }
    
    private static void swap(int[] nums, int left, int right) {
    	int temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {2, 1, 5, 4, 3, 5};
    	int k = 2;
    	System.out.println(findKthLargest(nums, k));
    }
}
