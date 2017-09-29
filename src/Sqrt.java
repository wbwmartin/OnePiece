//Implement int sqrt(int x).
//
//        Compute and return the square root of x.

public class Sqrt {

    public static int sqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4)); // 2
        System.out.println(sqrt(999999)); // 999
    }
}
