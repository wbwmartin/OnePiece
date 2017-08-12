
public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[nums.length];
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= temp;
            temp *= nums[i];
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] a = {1, 2, 3, 4};
    	for (Integer i : productExceptSelf(a)) {
    		System.out.print(i + " ");
    	}
    }
}
