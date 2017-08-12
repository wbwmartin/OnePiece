
public class NextPermutation {
	
	// iterative
    public static void nextPermutation(int[] nums) {
    	if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] a = {1, 3, 2};
    	nextPermutation(a);
    	for (Integer i: a) {
    		System.out.print(i + " "); // 2 1 3
    	}
    }
}
