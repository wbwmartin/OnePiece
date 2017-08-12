
public class TrappingRainWater {
	
	// iterative, O(n) time, O(n) space
    public static int trap(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int sum = 0;
        int max = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            int diff = Math.min(left[i], right[i]) - height[i];
            if (diff > 0) {
                sum += diff;
            }
        }
        return sum;
    }
    
    // O(n) time, O(1) space
    public static int trap2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = heights.length - 1;
        int min = Math.min(heights[left], heights[right]);
        boolean flag = min == heights[left] ? true : false;
        
        while (left < right) {
            if (flag) {
                left++;
            } else {
                right--;
            }
            int h = flag ? heights[left] : heights[right];
            if (h < min) {
                res += min - h;
            } else {
                min = Math.min(heights[left], heights[right]);
                flag = min == heights[left] ? true : false;
            }
        }
        return res;
    }
    
    // unit test
    public static void main(String[] args) {
    	int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    	System.out.println(trap2(h)); // 6
    }
}

