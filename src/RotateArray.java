
public class RotateArray {

	// iterative
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            nums[left] = nums[left] + nums[right];
            nums[right] = nums[left] - nums[right];
            nums[left] = nums[left] - nums[right];
            left++;
            right--;
        }
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {1, 2, 3, 4, 5, 6, 7};
    	int k = 3;
    	rotate(nums, k);
    	for (Integer i: nums) {
    		System.out.print(i + " ");
    	}
    }
}
