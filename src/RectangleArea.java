//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//        Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//        Rectangle Area
//        Assume that the total area is never beyond the maximum possible value of int.

public class RectangleArea {

    public static int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > C || B > D || E > G || F > H) {
            return 0;
        }
        long sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (C <= E || G <= A || D <= F || H <= B) {
            return (int) sum;
        }
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(H, D);
        int bottom = Math.max(F, B);
        return (int) (sum - (right - left) * (top - bottom));
    }

    public static void main(String[] args) {
        int res = computeArea2(0, 0, 0, 0, -1, -1, 1, 1);
        int res2 = computeArea2(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
        System.out.println(res); // 4
        System.out.println(res2); // 2
    }
}
