
public class RectangleArea {

	// iterative, complicated
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > C || B > D || E > G || F > H) {
            return 0;
        }
        long sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (sum > Integer.MAX_VALUE) {
            return 0;
        }
        int length = -1;
        int width = -1;
        for (int i = A; i <= C; i++) {
            if (i >= E && i <= G) {
                length++;
            }
        }
        for (int i = B; i <= D; i++) {
            if (i >= F && i <= H) {
                width++;
            }
        }
        if (length < 0) {
        	length = 0;
        }
        if (width < 0) {
        	width = 0;
        }
        return (int) (sum - length * width);
    }
    
    // simplified
    public static int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (A > C || B > D || E > G || F > H) {
            return 0;
        }
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (C <= E || G <= A || D <= F || H <= B) {
            return sum;
        }
        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(H, D);
        int bottom = Math.max(F, B);
        return sum - (right - left) * (top - bottom);
    }
    
    /*public static int computeArea0(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        if (sum > Integer.MAX_VALUE) {
            return 0;
        }
        int diff1 = getDiff(A, C, E, G);
        int diff2 = getDiff(B, D, F, H);
        return (int) (sum - diff1 * diff2);
    }
    
    private static int getDiff(int a, int b, int c, int d) {
        return Math.max(Math.min(b, d) - Math.max(a, c), 0);
    }*/
    
    // unit test
    public static void main(String[] args) {
    	int res = computeArea2(0, 0, 0, 0, -1, -1, 1, 1);
    	int res2 = computeArea2(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1);
    	System.out.println(res); // 4
    	System.out.println(res2); // 2
    }
}
