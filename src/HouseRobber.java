import java.util.Arrays;


public class HouseRobber {
	
	// dp
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] money = new int[nums.length + 1];
        money[0] = 0;
        money[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i - 1]);
        }
        return money[nums.length];
    }
    
    // dp, no space
    public static int rob0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(sum1 + nums[i], sum2);
            sum1 = sum2;
            sum2 = temp;
        }
        return Math.max(sum1, sum2);
    }
    
    // dp, circle
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] left = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] right = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob(left), rob(right));
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {2, 1, 3, 6};
    	System.out.println(rob(nums));
    	System.out.println(rob2(nums));
    }

}
