//Implement double sqrt(double x) and x >= 0.
//
//        Compute and return the square root of x.
//
//        Notice
//
//        You do not care about the accuracy of the result, we will help you to output results.
//
//        Example
//        Given n = 2 return 1.41421356

public class SqrtII {

    public static double sqrt(double x) {
        double left = 0.0;
        double right = x;
        double eps = 1e-12;
        if (right < 1.0) {
            left = x;
            right = 1.0;
        }
        while (right - left > eps) {
            double mid = (left + right) / 2;
            if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(2)); // 1.41421356
    }
}
