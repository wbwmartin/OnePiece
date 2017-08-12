
public class PowerTwo {
	
	// iterative
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    // bit
	public static boolean isPowerOfTwo2(int n) {  
		return n > 0 && (n & (n - 1)) == 0;  
	}
	
    // unit test
    public static void main(String[] args) {
    	System.out.println(isPowerOfTwo2(8));
    }
}
