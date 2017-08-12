
public class PalindromeNumber {

	// iterative, overflow case
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        long sum = 0;
        while (y != 0) {
            sum = sum * 10 + y % 10;
            y /= 10;
        }
        return (int) sum == x;
    }
    
    // iterative, no overflow
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            if (x % 10 != x / div) {
                return false;
            }
            x = x % div / 10;
            div /= 100;
        }
        return true;
    }
    
    // unit test
    public static void main(String[] args) {
    	int i = 12321;
    	System.out.println(isPalindrome(i));
    }
}
