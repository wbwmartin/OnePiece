//Write a program to check whether a given number is an ugly number`.
//
//        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
//
//        Notice
//
//        Note that 1 is typically treated as an ugly number.
//
//        Example
//        Given num = 8 return true
//        Given num = 14 return false

public class UglyNumber {

    public static boolean isUgly(int num) {
        // write your code here
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(8)); // true
        System.out.println(isUgly(14)); // false
    }
}
