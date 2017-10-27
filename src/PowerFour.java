// Given an integer, write a function to determine if it is a power of four.

public class PowerFour {

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16)); // true
        System.out.println(isPowerOfFour(8)); // false
    }
}
