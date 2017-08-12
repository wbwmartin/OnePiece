
public class NumberOneBits {

	// bit
    public static int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n = n >> 1;
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(hammingWeight(7)); // 3
    	System.out.println(-1>>>1);
    	System.out.println(Math.pow(2, 31) - 1);
    }
}
