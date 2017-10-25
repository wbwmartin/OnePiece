import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//Find K-th largest element in N arrays.
//
//        Notice
//
//        You can swap elements in the array
//
//        Example
//        In n=2 arrays [[9,3,2,4,7],[1,2,3,4,8]], the 3rd largest element is 7.
//
//        In n=2 arrays [[9,3,2,4,8],[1,2,3,4,2]], the 1st largest element is 9, 2nd largest element is 8, 3rd largest element is 7 and etc.

public class KthLargestNArrays {

    public static int KthInArrays(int[][] arrays, int k) {
        Queue<Node> pq = new PriorityQueue<>(k, Comparator.comparing((Node n) -> n.val).reversed());
        Node node = null;
        for (int i = 0; i < arrays.length; i++) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                pq.offer(new Node(arrays[i][arrays[i].length - 1], i, arrays[i].length - 1));
            }
        }
        for (int i = 0; i < k; i++) {
            node = pq.poll();
            if (node.pos > 0) {
                pq.offer(new Node(arrays[node.index][node.pos - 1], node.index, node.pos - 1));
            }
        }
        return node.val;
    }

    public static class Node {
        public int val, index, pos;

        public Node(int val, int index, int pos) {
            this.val = val;
            this.index = index;
            this.pos = pos;
        }
    }

    public static void main(String[] args) {
        int[][] arrays = {{9, 3, 2, 4, 7}, {1, 2, 3, 4, 8}};
        System.out.println(KthInArrays(arrays, 3)); // 7
    }

}
