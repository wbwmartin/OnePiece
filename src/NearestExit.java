import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {

    private static final int INF = 2147483647;

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q1.offer(i);
                    q2.offer(j);
                }
            }
        }
        while (!q1.isEmpty()) {
            int x = q1.poll();
            int y = q2.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < rooms.length && ny >= 0 && ny < rooms[0].length && rooms[nx][ny] == INF) {
                    q1.offer(nx);
                    q2.offer(ny);
                    rooms[nx][ny] = rooms[x][y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }
}
