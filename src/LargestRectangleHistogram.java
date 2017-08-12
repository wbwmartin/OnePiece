import java.util.Stack;


public class LargestRectangleHistogram {

	// stack
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.empty() && height[stack.peek()] >= cur) {
                int h = height[stack.pop()];
                int w = (stack.empty()) ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] h = {2, 1, 5, 6, 2, 3}; // 10
    	System.out.println(largestRectangleArea(h));
    }
}
