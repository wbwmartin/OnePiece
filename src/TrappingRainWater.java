//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//        For example,
//        Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//
//
//        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

public class TrappingRainWater {

    public static int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = heights.length - 1;
        int min = Math.min(heights[left], heights[right]);

        while (left < right) {
            int h;
            if (heights[left] < heights[right]) {
                left++;
                h = heights[left];
            } else {
                right--;
                h = heights[right];
            }
            if (h < min) {
                res += min - h;
            } else {
                min = Math.min(heights[left], heights[right]);
            }
        }
        return res;
    }

    // unit test
    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapRainWater(h)); // 6
    }
}

