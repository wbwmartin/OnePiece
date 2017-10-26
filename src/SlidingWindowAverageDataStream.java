import java.util.LinkedList;
import java.util.Queue;

//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
//
//
//        Example
//        MovingAverage m = new MovingAverage(3);
//        m.next(1) = 1 // return 1.00000
//        m.next(10) = (1 + 10) / 2 // return 5.50000
//        m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
//        m.next(5) = (10 + 3 + 5) / 3 // return 6.00000

public class SlidingWindowAverageDataStream {

    private Queue<Integer> queue;
    private double sum = 0.0;
    private int size;

    /** Initialize your data structure here. */
    public SlidingWindowAverageDataStream(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        // Write your code here
        sum += val;
        if (queue.size() == size) {
            sum = sum - queue.poll();
        }
        queue.offer(val);
        return sum / queue.size();
    }

    public static void main(String[] args) {
        SlidingWindowAverageDataStream m = new SlidingWindowAverageDataStream(3);
        System.out.println(m.next(1)); // 1.0
        System.out.println(m.next(10)); // 5.5
        System.out.println(m.next(3)); // 4.66667
        System.out.println(m.next(5)); // 6.0
    }
}
