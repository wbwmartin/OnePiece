import java.util.HashSet;
import java.util.Set;


public class HappyNumber {
	
	// iterative
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }
    
    private static int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    // unit test
    public static void main(String[] args) {
    	System.out.println(isHappy(19));
    }
}
