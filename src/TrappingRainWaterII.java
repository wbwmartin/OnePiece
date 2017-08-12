import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class TrappingRainWaterII {

	private static class Cell {
        int x;
        int y;
        int h;
        
        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
	
    public static int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                return c1.h - c2.h;
            }
        });
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heights[i][0]));
            pq.offer(new Cell(i, n - 1, heights[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pq.offer(new Cell(0, i, heights[0][i]));
            pq.offer(new Cell(m - 1, i, heights[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                pq.offer(new Cell(nx, ny, Math.max(cur.h, heights[nx][ny])));
                visited[nx][ny] = true;
                if (cur.h > heights[nx][ny]) {
                    res += cur.h - heights[nx][ny];
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {

    }
}
