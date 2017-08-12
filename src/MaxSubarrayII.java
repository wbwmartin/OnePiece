import java.util.ArrayList;
import java.util.Arrays;


public class MaxSubarrayII {

	public static int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
		if (nums == null || nums.size() == 0) {
            return 0;
        } 
        int[] left = new int[nums.size() + 1];
        int max = nums.get(0);
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.size(); i++) {
            sum = Math.max(sum + nums.get(i - 1), nums.get(i - 1));
            max = Math.max(max, sum);
            left[i] = max;
        }       
        max = nums.get(nums.size() - 1);
        sum = 0;
        for (int i = nums.size() - 1; i >= 1; i--) {
            sum = Math.max(sum + nums.get(i), nums.get(i));
            max = Math.max(max, sum);
            res = Math.max(res, left[i] + max);  
            System.out.println("max: "+max+"left:"+left[i]);
        }   
        return res;
    }
	
	// unit test
    public static void main(String[] args) {
    	Integer[] a = {-2,2,-3,4,-1,2,1,-5,3};
    	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(a));
    	System.out.println(maxTwoSubArrays(list));
    }
}
