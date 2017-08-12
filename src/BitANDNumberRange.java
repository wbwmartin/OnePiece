//Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise
// AND of all numbers in this range, inclusive.
//
//        For example, given the range [5, 7], you should return 4.

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
