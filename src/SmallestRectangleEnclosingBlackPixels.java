//An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
// The black pixels are connected, i.e., there is only one black region.
// Pixels are connected horizontally and vertically.
// Given the location (x, y) of one of the black pixels, return the area of the smallest
// (axis-aligned) rectangle that encloses all black pixels.
//
//        Example
//        For example, given the following image:
//
//        [
//        "0010",
//        "0110",
//        "0100"
//        ]
//        and x = 0, y = 2,
//        Return 6.

public class SmallestRectangleEnclosingBlackPixels {

    // http://www.cnblogs.com/yrbbest/p/5050022.html
    // O(mlogn + nlogm)
    public static int minArea(char[][] image, int x, int y) {
        // write your code here
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        int m = image.length;
        int n = image[0].length;
        int left = helper(image, 0, y, 0, m, true, true);
        int right = helper(image, y + 1, n, 0, m, true, false);
        int up = helper(image, 0, x, left, right, false, true);
        int down = helper(image, x + 1, m, left, right, false, false);
        return (right - left) * (down - up);
    }

    private static int helper(char[][] image, int start, int end, int min, int max, boolean horizontal, boolean low) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean hasBlackPixel = false;
            for (int i = min; i < max; i++) {
                if ((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    hasBlackPixel = true;
                    break;
                }
            }
            if (hasBlackPixel == low) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        char[][] image = {{'0', '0', '1', '0' }, {'0', '1', '1', '0' }, {'0', '1', '0', '0' }};
        System.out.println(minArea(image, 0, 2)); // 6
    }
}
