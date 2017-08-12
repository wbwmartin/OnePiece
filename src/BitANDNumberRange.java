
public class BitANDNumberRange {

    public static int rangeBitwiseAnd(int m, int n) {
        if (m > n) {
            return 0;
        }
        int i = 0;
        while (m > 0 && m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
    
    // unit test
    public static void main(String[] args) {
    	int m = 5;
    	int n = 7;
    	System.out.println(rangeBitwiseAnd(m, n)); // 4
    }
}
