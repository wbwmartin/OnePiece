import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.
//
//
//        Example
//        For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]
//
//        At first the window is at the start of the array like this
//
//        [|1, 2, 7| ,7, 8] , return the maximum 7;
//
//        then the window move one step forward.
//
//        [1, |2, 7 ,7|, 8], return the maximum 7;
//
//        then the window move one step forward again.
//
//        [1, 2, |7, 7, 8|], return the maximum 8;
//
//        Challenge
//        o(n) time and O(k) memory

public class SlidingWindowMaximum {

    public static ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }
        for (int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            ans.add(deque.peekFirst());
            outQueue(deque, nums[i - k + 1]);
        }
        return ans;
    }

    private static void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }

    private static void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 7, 8};
        System.out.println(maxSlidingWindow(nums, 3)); // 7 7 8
    }
}
