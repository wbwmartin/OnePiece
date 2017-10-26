import java.util.ArrayList;
import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//        Notice
//
//        Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
//
//
//        Example
//        Given the following triangle:
//
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//

public class Triangle {

    public static int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return 0;
        }
        int n = triangle.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = triangle[i][j] + Math.min(res[j], res[j + 1]);
            }
        }
        return res[0];
    }

    // unit test
    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(minimumTotal(triangle)); // 11
    }
}
