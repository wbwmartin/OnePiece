
public class SortColors {

	// iterative
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int cur = left;
        while (cur <= right) {
            if (nums[cur] == 0) {
                int temp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = temp;
                cur++;
                left++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                int temp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = temp;
                right--;
            }
        }
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {2, 0, 1, 1, 2, 1, 1, 0};
    	sortColors(nums);
    	for (Integer i: nums) {
    		System.out.print(i + " ");
    	}
    }
}
