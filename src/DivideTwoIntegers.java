//Divide two integers without using multiplication, division and mod operator.
//
//        If it is overflow, return MAX_INT.

public class DivideTwoIntegers {

    // iterative, O(n), bad
    public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = false;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int count = -1;
        while (dividend > 0) {
            count++;
            dividend -= divisor;
        }
        if (sign) {
            count = -count;
        }
        return count;
    }

    // iterative, O(log(n)), good
    public static int divide2(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative ? -result : result;
    }

    // unit test
    public static void main(String[] args) {
        int res = divide2(-5, 2);
        System.out.println(res); // -2
    }
}