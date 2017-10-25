import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Given n x m non-negative integers representing an elevation map 2d where the area of each cell is 1 x 1, compute how much water it is able to trap after raining.
//
//        Example
//        Given 5*4 matrix
//
//        [12,13,0,12]
//        [13,4,13,12]
//        [13,8,10,12]
//        [12,13,12,12]
//        [13,13,13,13]
//        return 14.

public class TrappingRainWaterII {

    public static int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        int res = 0;
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> pq = new PriorityQueue<>(1, Comparator.comparing(Cell::getVal));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heights[0][j]));
            pq.offer(new Cell(m - 1, j, heights[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        while (!pq.isEmpty()) {
            Cell min = pq.poll();
            int x = min.x;
            int y = min.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new Cell(nx, ny, Math.max(min.val, heights[nx][ny])));
                    res += Math.max(0, min.val - heights[nx][ny]);
                }
            }
        }
        return res;
    }

    public static class Cell {
        public int x, y, val;

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{12, 13, 0, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}};
        System.out.println(trapRainWater(heights)); // 14
    }
}
