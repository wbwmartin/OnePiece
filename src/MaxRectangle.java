import java.util.Stack;

//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing
// only 1's and return its area.
//
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//        Return 6.

public class MaxRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }

    private static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
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
        char[][] matrix = {{'0', '1', '0'}, {'0', '1', '1'}, {'1', '1', '0'}};
        System.out.println(maximalRectangle(matrix)); // 3
    }

}
