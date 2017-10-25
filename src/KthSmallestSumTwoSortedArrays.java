import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.
//
//        Example
//        Given [1, 7, 11] and [2, 4, 6].
//
//        For k = 3, return 7.
//
//        For k = 4, return 9.
//
//        For k = 8, return 15.
//
//        Challenge
//        Do it in either of the following time complexity:
//
//        O(k log min(n, m, k)). where n is the size of A, and m is the size of B.
//        O( (m + n) log maxValue). where maxValue is the max number in A and B.

public class KthSmallestSumTwoSortedArrays {

    public static int kthSmallestSum(int[] A, int[] B, int k) {
        boolean[][] visited = new boolean[A.length][B.length];
        Queue<Pair> pq = new PriorityQueue<>(k, Comparator.comparing(Pair::getValue));
        Pair pair = new Pair(0, 0, A[0] + B[0]);
        pq.offer(pair);
        visited[0][0] = true;
        for (int i = 0; i < k; i++) {
            pair = pq.poll();
            if (pair.x < A.length - 1 && !visited[pair.x + 1][pair.y]) {
                pq.offer(new Pair(pair.x + 1, pair.y, A[pair.x + 1] + B[pair.y]));
                visited[pair.x + 1][pair.y] = true;
            }
            if (pair.y < B.length - 1 && !visited[pair.x][pair.y + 1]) {
                pq.offer(new Pair(pair.x, pair.y + 1, A[pair.x] + B[pair.y + 1]));
                visited[pair.x][pair.y + 1] = true;
            }
        }
        return pair.val;
    }

    public static class Pair {
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
        int[] A = {1, 7, 11};
        int[] B = {2, 4, 6};
        System.out.println(kthSmallestSum(A, B, 3)); // 7
        System.out.println(kthSmallestSum(A, B, 4)); // 9
        System.out.println(kthSmallestSum(A, B, 8)); // 15
    }

}
