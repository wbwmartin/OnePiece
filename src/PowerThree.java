// Given an integer, write a function to determine if it is a power of three.

public class PowerThree {

    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27)); // true
    }
}
