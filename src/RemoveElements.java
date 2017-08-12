
public class RemoveElements {
	
	// iterative
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] A = {1, 2, 3, 2, 4};
    	int elem = 2;
    	System.out.println(removeElement(A, elem)); // 3
    }
}
