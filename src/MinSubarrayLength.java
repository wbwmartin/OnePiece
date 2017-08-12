
public class MinSubarrayLength {

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0 || s <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (left = 0; left < nums.length; left++) {
            while(right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }
            if (sum >= s) {
                len = Math.min(len, right - left);
            }
            sum -= nums[left];
        }
        if (len == Integer.MAX_VALUE) {
            return 0;
        }
        return len;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] nums = {2, 3, 1, 2, 4, 3};
    	int s = 7;
    	System.out.println(minSubArrayLen(s, nums));
    }
}
