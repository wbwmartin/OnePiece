
public class MaxSubarray {
	
	// dp
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
    
    // dp
    public static int maxSubArray2(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    	System.out.println(maxSubArray2(a));
    }

}
