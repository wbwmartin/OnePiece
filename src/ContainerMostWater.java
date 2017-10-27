//Given n non-negative integers a1, a2, ..., an, where each represents a point at
// coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
// line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
// forms a container, such that the container contains the most water.
//
//        Note: You may not slant the container and n is at least 2.

public class ContainerMostWater {

    // iterative
    public static int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, temp);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] h = {3, 2, 5, 4, 1}; // 9
        System.out.println(maxArea(h));
    }
}
