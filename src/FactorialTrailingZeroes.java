
public class FactorialTrailingZeroes {

	// iterative
    public static int trailingZeroes(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(trailingZeroes(25)); // 6
    }
}
