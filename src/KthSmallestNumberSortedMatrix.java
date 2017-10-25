import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Find the kth smallest number in at row and column sorted matrix.
//
//        Example
//        Given k = 4 and a matrix:
//
//        [
//        [1 ,5 ,7],
//        [3 ,7 ,8],
//        [4 ,8 ,9],
//        ]
//        return 5
//
//        Challenge
//        Solve it in O(k log n) time where n is the bigger one between row size and column size.

public class KthSmallestNumberSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        Queue<Pair> pq = new PriorityQueue<>(k, Comparator.comparing(Pair::getValue));
        Pair pair = new Pair(0, 0, matrix[0][0]);
        pq.offer(pair);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        for (int i = 0; i < k; i++) {
            pair = pq.poll();
            if (pair.x + 1 < matrix.length && !visited[pair.x + 1][pair.y]) {
                pq.offer(new Pair(pair.x + 1, pair.y, matrix[pair.x + 1][pair.y]));
                visited[pair.x + 1][pair.y] = true;
            }
            if (pair.y + 1 < matrix[0].length && !visited[pair.x][pair.y + 1]) {
                pq.offer(new Pair(pair.x, pair.y + 1, matrix[pair.x][pair.y + 1]));
                visited[pair.x][pair.y + 1] = true;
            }
        }
        return pair.val;
    }

    public static class Pair{
        public int x, y, val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getValue() {
            return this.val;
        }
    }

    public static void main(String[] args) {

    }
}
