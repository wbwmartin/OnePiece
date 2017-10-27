// Implement pow(x, n).

public class Pow {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        boolean sign = false;
        if (n < 0) {
            sign = true;
            n *= -1;
        }
        double res;
        if (n % 2 == 0) {
            res = myPow(x * x, n / 2);
        } else {
            res = myPow(x * x, n / 2) * x;
        }
        return sign ? 1 / res : res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -1));
    }
}
