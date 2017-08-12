
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
    
    // unit test
    public static void main(String[] args) {
    	int[] h = {3, 2, 5, 4, 1};
    	System.out.println(maxArea(h));
    }
}
