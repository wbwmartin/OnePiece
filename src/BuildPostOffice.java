import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one),
// find the place to build a post office, the distance that post office to all the house sum
// is smallest. Return the smallest distance. Return -1 if it is not possible.
//
//        Notice
//
//        You can pass through house and empty.
//        You only build post office on an empty.
//
//        Example
//        Given a grid:
//
//        0 1 0 0
//        1 0 1 1
//        0 1 0 0
//        return 6. (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)


public class BuildPostOffice {

    // time O(n^2*logk), space O(k)
    public static int shortestDistance(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        List<Integer> onex = new ArrayList<>();
        List<Integer> oney = new ArrayList<>();
        List<Integer> sumx = new ArrayList<>();
        List<Integer> sumy = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    onex.add(i);
                    oney.add(j);
                }
            }
        }
        Collections.sort(onex);
        Collections.sort(oney);
        sumx.add(0);
        sumy.add(0);
        for (int i = 1; i <= onex.size(); i++) {
            sumx.add(sumx.get(i - 1) + onex.get(i - 1));
            sumy.add(sumy.get(i - 1) + oney.get(i - 1));
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int costx = getCost(onex, sumx, i);
                    int costy = getCost(oney, sumy, j);
                    res = Math.min(res, costx + costy);
                }
            }
        }
        return res;
    }

    // binary search
    private static int getCost(List<Integer> one, List<Integer> sum, int pos) {
        int n = one.size();
        if (n == 0) {
            return 0;
        }
        if (one.get(0) > pos) {
            return sum.get(n) - pos * n;
        }
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (one.get(mid) <= pos) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int index = one.get(right) <= pos ? right : left;
        int leftSum = pos * (index + 1) - sum.get(index + 1);
        int rightSum = sum.get(n) - sum.get(index + 1) - pos * (n - index - 1);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 0, 1, 1}, {0, 1, 0, 0}};
        System.out.println(shortestDistance(grid)); // 6
    }
}
