import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class DataStreamMedian {

    public static int[] medianII(int[] nums) {
        // write your code here
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length];
        Queue<Integer> min = new PriorityQueue<Integer>();
        Queue<Integer> max = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
            });
        res[0] = nums[0];
        max.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int med = max.peek();
            if (nums[i] <= med) {
                max.offer(nums[i]);
            } else {
                min.offer(nums[i]);
            }
            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            } else if (max.size() < min.size()) {
                max.offer(min.poll());
            }
            res[i] = max.peek();
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {4, 5, 1, 3, 2, 6, 0};
    	int[] res = medianII(nums);
    	for (int i : res) {
    		System.out.print(i + " "); // 4, 4, 4, 3, 3, 3, 3
    	}
    }
}
