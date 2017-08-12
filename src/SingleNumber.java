
public class SingleNumber {
	
	// Q1
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (Integer x: nums) {
            sum ^= x;
        }
        return sum;
    }
	
	// Q2
    public static int singleNumber2(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        int[] digit = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                digit[i] += A[j] >> i & 1;
                digit[i] %= 3;
            }
            res |= digit[i] << i;
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] a = {3, 3, 2, 5, 2};
    	int[] b = {1, 3, 2, 3, 3, 1, 1};
    	System.out.println(singleNumber(a));
    	System.out.println(singleNumber2(b));
    }
}
