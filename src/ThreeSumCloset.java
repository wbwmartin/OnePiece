import java.util.Arrays;


public class ThreeSumCloset {

	// iterative
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE / 2;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(sum - target) < Math.abs(closet - target)) {
                    closet = sum;
                }
            }
        }
        return closet;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {-1, 2, 1, -4};
    	int target = 1;
    	System.out.println(threeSumClosest(nums, target));
    }
}
