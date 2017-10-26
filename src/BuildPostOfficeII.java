import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.
//
//        Return the smallest sum of distance. Return -1 if it is not possible.
//
//        Notice
//
//        You cannot pass through wall and house, but can pass through empty.
//        You only build post office on an empty.
//
//        Example
//        Given a grid:
//
//        0 1 0 0 0
//        1 0 0 2 1
//        0 1 0 0 0
//        return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)
//
//        Challenge
//        Solve this problem within O(n^3) time.

public class BuildPostOfficeII {

    public static int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] distanceSum = new int[m][n];
        int[][] visitedTimes = new int[m][n];
        int res = Integer.MAX_VALUE;
        List<Point> houses = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }
        for (Point house : houses) {
            bfs(house, grid, distanceSum, visitedTimes);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visitedTimes[i][j] == houses.size()) {
                    res = Math.min(res, distanceSum[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static void bfs(Point house, int[][] grid, int[][] distanceSum, int[][] visitedTimes) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int m = distanceSum.length;
        int n = distanceSum[0].length;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(house);
        visited[house.x][house.y] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = point.x + dx[j];
                    int ny = point.y + dy[j];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        distanceSum[nx][ny] += steps;
                        visitedTimes[nx][ny]++;
                    }
                }
            }
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0, 0}, {1, 0, 0, 2, 1}, {0, 1, 0, 0, 0}};
        System.out.println(shortestDistance(grid)); // 8
    }
}
