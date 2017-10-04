import java.util.*;

//Numbers keep coming, return the median of numbers at every time a new number added.
//
//        What's the definition of Median?
//        - Median is the number that in the middle of a sorted array.
//          If there are n numbers in a sorted array A, the median is A[(n - 1) / 2].
//          For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
//
//        Example
//        For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
//
//        For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
//
//        For numbers coming list: [2, 20, 100], return [2, 2, 20].
//
//        Challenge
//        Total run time in O(nlogn).

public class DataStreamMedian {

    public static int[] medianII(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] res = new int[nums.length];
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(11, Collections.reverseOrder());
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
